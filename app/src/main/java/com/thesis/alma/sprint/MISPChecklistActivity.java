package com.thesis.alma.sprint;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.DecimalFormat;
import java.util.Calendar;


public class MISPChecklistActivity extends BaseActivity implements View.OnClickListener {

    private EditText etStartDate;
    private Button mispobj1, mispobj2, mispobj3, mispobj4, mispobj5;

    private GoogleMap googleMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mispchecklist);

        googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

        final LatLng TutorialsPoint = new LatLng(21, 57);
        googleMap.addMarker(new MarkerOptions().position(TutorialsPoint).title("My Location"));
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        googleMap.getUiSettings().setZoomGesturesEnabled(true);


        etStartDate = (EditText) findViewById(R.id.startdate);
        etStartDate.setOnClickListener(this);

        mispobj1 = (Button) findViewById(R.id.mispobj1);
        mispobj2 = (Button) findViewById(R.id.mispobj2);
        mispobj3 = (Button) findViewById(R.id.mispobj3);
        mispobj4 = (Button) findViewById(R.id.mispobj4);
        mispobj5 = (Button) findViewById(R.id.mispobj5);

        mispobj1.setOnClickListener(this);
        mispobj2.setOnClickListener(this);
        mispobj3.setOnClickListener(this);
        mispobj4.setOnClickListener(this);
        mispobj5.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mispchecklist, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startdate:

                Calendar c = Calendar.getInstance();
                c.setTimeInMillis(System.currentTimeMillis());
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                final DecimalFormat mFormat = new DecimalFormat("00");
                DatePickerDialog mDatePicker = new DatePickerDialog(MISPChecklistActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            public void onDateSet(DatePicker datepicker,
                                                  int selectedyear, int selectedmonth,
                                                  int selectedday) {
                                etStartDate.setText(mFormat.format(selectedday)
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
            case R.id.mispobj1:
                Intent myIntent1 = new Intent(this, MISPObjActivity.class);
                myIntent1.putExtra(Constant.ENUM_KEY, MISPObjActivity.Obj.MISPOBJ1.ordinal());
                startActivity(myIntent1);
                break;
            case R.id.mispobj2:
                Intent myIntent2 = new Intent(this, MISPObjActivity.class);
                myIntent2.putExtra(Constant.ENUM_KEY, MISPObjActivity.Obj.MISPOBJ2.ordinal());
                startActivity(myIntent2);
                break;
            case R.id.mispobj3:
                Intent myIntent3 = new Intent(this, MISPObjActivity.class);
                myIntent3.putExtra(Constant.ENUM_KEY, MISPObjActivity.Obj.MISPOBJ3.ordinal());
                startActivity(myIntent3);
                break;
            case R.id.mispobj4:
                Intent myIntent4 = new Intent(this, MISPObjActivity.class);
                myIntent4.putExtra(Constant.ENUM_KEY, MISPObjActivity.Obj.MISPOBJ4.ordinal());
                startActivity(myIntent4);
                break;
            case R.id.mispobj5:
                Intent myIntent5 = new Intent(this, MISPObjActivity.class);
                myIntent5.putExtra(Constant.ENUM_KEY, MISPObjActivity.Obj.MISPOBJ5.ordinal());
                startActivity(myIntent5);
                break;
        }
    }
}
