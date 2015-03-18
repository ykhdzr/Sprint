package com.thesis.alma.sprint;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.DecimalFormat;


public class BeneficiaryActivity extends BaseActivity implements View.OnClickListener {

    private EditText etDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beneficiary);
        etDate = (EditText) findViewById(R.id.date);
        etDate.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_beneficiary, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.date:
                final int M_YEAR = 1980;
                final int M_MONTH = 0;
                final int M_DAY = 1;

                final DecimalFormat mFormat = new DecimalFormat("00");
                DatePickerDialog mDatePicker = new DatePickerDialog(BeneficiaryActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            public void onDateSet(DatePicker datepicker,
                                                  int selectedyear, int selectedmonth,
                                                  int selectedday) {
                                etDate.setText(mFormat.format(selectedday)
                                                + "-"
                                                + mFormat.format(selectedmonth + 1)
                                                + "-" +
                                                mFormat.format(selectedyear)
                                );
                            }
                        }, M_YEAR, M_MONTH, M_DAY);
                mDatePicker.setTitle("Select date");
                mDatePicker.show();
                break;
        }
    }
}
