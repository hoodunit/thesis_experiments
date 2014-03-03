package org.helloandroid.core;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;

public class LoaderActivity extends Activity {
    private static final String TAG = "LoaderActivity";

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        
        Debug.startMethodTracing("/sdcard/dmtrace.trace", 100000000);
        startActivity(new Intent("org.helloandroid.core.MAIN"));
        finish();
    }
}
