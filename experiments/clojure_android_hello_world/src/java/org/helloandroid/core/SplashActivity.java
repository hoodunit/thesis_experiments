package org.helloandroid.core;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;
//import android.os.Debug;

import clojure.lang.Symbol;
import clojure.lang.Var;
import clojure.lang.RT;

import org.helloandroid.core.R;

public class SplashActivity extends Activity {

    private static boolean firstLaunch = true;
    private static String TAG = "Splash";

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        if (firstLaunch) {
            firstLaunch = false;
            setupSplash();
            loadClojure();
        } else {
            proceed();
        }
    }

    public void setupSplash() {
        setContentView(R.layout.splashscreen);

        TextView appNameView = (TextView)findViewById(R.id.splash_app_name);
        appNameView.setText(R.string.app_name);

        Animation rotation = AnimationUtils.loadAnimation(this, R.anim.splash_rotation);
        ImageView circleView = (ImageView)findViewById(R.id.splash_circles);
        circleView.startAnimation(rotation);
    }

    public void proceed() {
        startActivity(new Intent("org.helloandroid.core.MAIN"));
        finish();
    }

    public void loadClojure() {
        new Thread(new Runnable(){
                @Override
                public void run() {
                    //Debug.startMethodTracing("/sdcard/dmtrace.trace", 8388608);
                    Symbol CLOJURE_MAIN = Symbol.intern("neko.init");
                    Var REQUIRE = RT.var("clojure.core", "require");
                    REQUIRE.invoke(CLOJURE_MAIN);

                    Var INIT = RT.var("neko.init", "init");
                    INIT.invoke(SplashActivity.this.getApplication());

                    try {
                        Class.forName("org.helloandroid.core.MyActivity");
                    } catch (ClassNotFoundException e) {
                        Log.e(TAG, "Failed loading MyActivity", e);
                    }

                    proceed();
                    //Debug.stopMethodTracing();
                }
            }).start();
    }
}
