package com.sriyanksiddhartha.filesystemdemo.storageoptions;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sriyanksiddhartha.filesystemdemo.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class ExternalStorageDemo extends AppCompatActivity {

    private EditText etExternalPrivate, etExternalPublic;
    private TextView txvExternalPrivate, txvExternalPublic;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.external_storage);

        etExternalPrivate = (EditText) findViewById(R.id.etExternalPrivate);
        etExternalPublic = (EditText) findViewById(R.id.etExternalPublic);

        txvExternalPrivate = (TextView) findViewById(R.id.txvExternalPrivate);
        txvExternalPublic = (TextView) findViewById(R.id.txvExternalPublic);
    }

    public void saveToExternalPrivate(View view) {

        String data = etExternalPrivate.getText().toString();

        File dir = getExternalFilesDir("MyFolder");
        File file = new File(dir, "myExternalPrivate.txt");

        writeToFile(file, data);

    }

    public void saveToExternalPublic(View view) {

        String data = etExternalPublic.getText().toString();

        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(dir, "myExternalPublic.txt");

        writeToFile(file, data);

    }

    public void loadFromExternalPrivate(View view) {


        File dir = getExternalFilesDir("MyFolder");
        File file = new File(dir, "myExternalPrivate.txt");

        txvExternalPrivate.setText(readFromFile(file));

    }

    public void loadFromExternalPublic(View view) {


        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(dir, "myExternalPublic.txt");

        txvExternalPublic.setText(readFromFile(file));

    }

    private void writeToFile(File file, String data) {

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(file);
            fos.write(data.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String readFromFile(File file) {

        StringBuffer stringBuffer = new StringBuffer();

        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);

            int read;
            while ((read = fis.read()) != -1) {
                stringBuffer.append((char) read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return stringBuffer.toString();
    }


}
