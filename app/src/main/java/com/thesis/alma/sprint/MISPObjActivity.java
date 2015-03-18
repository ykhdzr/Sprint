package com.thesis.alma.sprint;

import android.os.Bundle;
import android.view.Menu;


public class MISPObjActivity extends BaseActivity {

    public enum Obj {
        MISPOBJ1, MISPOBJ2, MISPOBJ3, MISPOBJ4, MISPOBJ5
    }

    private Obj obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        obj = (Obj) savedInstanceState.getSerializable(Constant.ENUM_KEY);

        switch (obj) {
            case MISPOBJ1:
                setContentView(R.layout.activity_mispobj1);
                break;
            case MISPOBJ2:
                setContentView(R.layout.activity_mispobj2);
                break;
            case MISPOBJ3:
                setContentView(R.layout.activity_mispobj3);
                break;
            case MISPOBJ4:
                setContentView(R.layout.activity_mispobj4);
                break;
            case MISPOBJ5:
                setContentView(R.layout.activity_mispobj5);
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mispobj, menu);
        return true;
    }
}
