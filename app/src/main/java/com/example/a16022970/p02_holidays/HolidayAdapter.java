package com.example.a16022970.p02_holidays;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public class HolidayAdapter extends ArrayAdapter<Holidays> {

    private Context context;
    private ArrayList<Holidays> holiday;
    TextView tvHols;
    ImageView iv;
    TextView tvName;
    TextView tvDate;

    public HolidayAdapter(Context context, int resource, ArrayList<Holidays>objects) {
        super(context,resource,objects);
        holiday = objects;
        this.context = context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvName = (TextView) rowView.findViewById(R.id.tvName);
        tvDate = (TextView) rowView.findViewById(R.id.tvDate);
        iv = (ImageView) rowView.findViewById(R.id.imageView);


        Holidays currentHol = holiday.get(position);

        tvName.setText(currentHol.getName());
        // Set the image to star or nostar accordingly
        if(currentHol.getName().equalsIgnoreCase("New Year's Day")) {
            tvDate.setText(currentHol.getDate());
            iv.setImageResource(R.drawable.newyear);
        }
        else if(currentHol.getName().equalsIgnoreCase("Labour Day")){
            tvDate.setText(currentHol.getDate());
            iv.setImageResource(R.drawable.labourday);
        }
        // Return the nicely done up View to the ListView
        return rowView;
    }

}
