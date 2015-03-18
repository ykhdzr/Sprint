package com.thesis.alma.sprint;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;


public class HomeActivity extends BaseActivity implements View.OnClickListener {

    private Button btnLogin, btnEmergency, btnReport, btnMisp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnLogin = (Button) findViewById(R.id.login_button);
        btnEmergency = (Button) findViewById(R.id.emergencyresp_button);
        btnReport = (Button) findViewById(R.id.report_button);
        btnMisp = (Button) findViewById(R.id.mispservice_button);

        btnLogin.setOnClickListener(this);
        btnEmergency.setOnClickListener(this);
        btnReport.setOnClickListener(this);
        btnMisp.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.emergencyresp_button:
                startActivity(new Intent(this, EmergencyActivity.class));
                break;
            case R.id.report_button:
                break;
            case R.id.mispservice_button:
                break;
        }
    }
}
