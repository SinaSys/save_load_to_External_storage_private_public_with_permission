package com.sriyanksiddhartha.filesystemdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sriyanksiddhartha.filesystemdemo.storageoptions.CacheStorageDemo;
import com.sriyanksiddhartha.filesystemdemo.storageoptions.ExternalStorageDemo;

/**
 * 	Author: Sriyank Siddhartha
 *
 * 	Module3: Working with External Storage
 *
 * 			"AFTER" Project
 * */
public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

/*		int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

		if (permissionCheck != PackageManager.PERMISSION_GRANTED) {

			ActivityCompat.requestPermissions(this,
					new String[] { Manifest.permission.WRITE_EXTERNAL_STORAGE }, 28);*/
		}


/*	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

		switch (requestCode) {

			case 28: {
				if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
					Log.i("MainActivity", "Permission Granted");
				} else { // Permission Denied : Disable the functionality related to the permission
					Log.i("MainActivity", "Permission Denied");
				}
			}
		}
	}*/

	public void openInternalStorageDemoActivity(View view) {

		//Intent intent = new Intent(this, InternalStorageDemo.class);
	//	startActivity(intent);
	}

	public void openCacheStorageDemoActivity(View view) {

	//	Intent intent = new Intent(this, CacheStorageDemo.class);
		//startActivity(intent);
	}

	public void openExternalStorageDemoActivity(View view) {

		Intent intent = new Intent(this, ExternalStorageDemo.class);
		startActivity(intent);
	}
}
