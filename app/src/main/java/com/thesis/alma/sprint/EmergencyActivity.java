package com.thesis.alma.sprint;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.util.Calendar;


public class EmergencyActivity extends BaseActivity implements View.OnClickListener {

    private EditText etDate;
    private Button btnMisp, btnBeneficiary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        etDate = (EditText) findViewById(R.id.dateofbirth);
        etDate.setOnClickListener(this);
        btnMisp = (Button) findViewById(R.id.mispchecklist_button);
        btnMisp.setOnClickListener(this);
        btnBeneficiary = (Button) findViewById(R.id.beneficiary_button);
        btnBeneficiary.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_emergency, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dateofbirth:

                Calendar c = Calendar.getInstance();
                c.setTimeInMillis(System.currentTimeMillis());
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                final DecimalFormat mFormat = new DecimalFormat("00");
                DatePickerDialog mDatePicker = new DatePickerDialog(EmergencyActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            public void onDateSet(DatePicker datepicker,
                                                  int selectedyear, int selectedmonth,
                                                  int selectedday) {
                                etDate.setText(mFormat.format(selectedday)
                                                + "/"
                                                + mFormat.format(selectedmonth + 1)
                                                + "/" +
                                                mFormat.format(selectedyear)
                                );
                            }
                        }, mYear, mMonth, mDay);
                mDatePicker.setTitle("Select date");
                mDatePicker.show();
                break;
            case R.id.mispchecklist_button:
                startActivity(new Intent(this, MISPChecklistActivity.class));
                break;
            case R.id.beneficiary_button:
                startActivity(new Intent(this, BeneficiaryActivity.class));
                break;
        }
    }
}
