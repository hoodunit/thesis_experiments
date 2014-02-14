package org.helloandroid.core;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class LoaderActivity extends Activity {
    private static final String TAG = "LoaderActivity";

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        
        startActivity(new Intent("org.helloandroid.core.MAIN"));
        finish();
    }
}
