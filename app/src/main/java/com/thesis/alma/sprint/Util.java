package com.thesis.alma.sprint;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by yokoahadazaro on 3/18/15.
 */
public class Util {

    private Util() {
    }

    public static void setFullScreen(Activity act) {
        act.requestWindowFeature(Window.FEATURE_NO_TITLE);
        act.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
