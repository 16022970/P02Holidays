package com.example.a16022970.p02_holidays;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity{
    ListView lv;
    TextView tvHols;
    ArrayAdapter aa;
    ArrayList<Holidays> holidays;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        Intent i = getIntent();
        final String hols = i.getStringExtra("hols");

        lv = (ListView)findViewById(R.id.lvHols);
        tvHols = (TextView) findViewById(R.id.tvHols);

        holidays = new ArrayList<Holidays>();
        if(hols.equalsIgnoreCase("Secular")){
            holidays.add(new Holidays("New Year's Day", "1 Jan 2017"));
            holidays.add(new Holidays("Labour Day", "1 May 2017"));

        } else{
            holidays.add(new Holidays("Chinese New Year", "28-29 Jan 2017"));
            holidays.add(new Holidays("Hari Raya Puasa", "15 May 2017"));
        }


        aa = new HolidayAdapter(this, R.layout.row, holidays);
        lv.setAdapter(aa);

        tvHols.setText(hols);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = holidays.get(position).getName().toString();
                String date = holidays.get(position).getDate().toString();
                Toast.makeText(Activity2.this, name + "Date: " + date, Toast.LENGTH_LONG).show();
            }
        });



    }

}
