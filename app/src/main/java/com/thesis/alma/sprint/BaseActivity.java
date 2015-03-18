package com.thesis.alma.sprint;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by yokoahadazaro on 3/18/15.
 */
abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Util.setFullScreen(this);
    }
}
