package com.zybooks.dickman_final_practical;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class PlaceOrderActivity extends AppCompatActivity {
    private String full_name;
    private String result;
    private String people;
    private String time;
    private String cost_ticket = DetailFragment.getCostTicket();
    private EditText num_tickets;
    private String total_cost;
    private TextView total_cost_view;
    private EditText firstName;
    private EditText LastName;
    private RadioGroup time_select_radio_group;
    private RadioButton time_select_early;
    private RadioButton time_select_late;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LastName = findViewById(R.id.submit_Last_name);
        firstName = findViewById(R.id.submit_First_name);
        num_tickets = findViewById(R.id.num_attend_edit_text);
        total_cost_view = findViewById(R.id.total_cost_cal);
        time_select_radio_group = findViewById(R.id.time_radio_group);
        time_select_early = findViewById(R.id.early_time_radio_button);
        time_select_late = findViewById(R.id.late_time_radio_button);

        time_select_late.setText(DetailFragment.getLateDateTime());
        time_select_early.setText(DetailFragment.getEarlyDateTime());

        Button button = findViewById(R.id.submit_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people = num_tickets.getText().toString();
                full_name = firstName.getText().toString() +" "+LastName.getText().toString();
                int checkedId = time_select_radio_group.getCheckedRadioButtonId();
                if (checkedId == R.id.late_time_radio_button) {
                    time = time_select_late.getText().toString();
                } else if (checkedId == R.id.early_time_radio_button) {
                    time = time_select_early.getText().toString();
                }
                result = "Name: "+ full_name +" "+LastName.getText().toString() +"\n" + "Number of tickets: "+ people +"\n" + "Total Cost: "+total_cost+"\n" +"Date: "+ time +"\n";
                Toast.makeText(PlaceOrderActivity.this, result, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void calculateClick(View view) {
        //get entered texts from the edittexts,and convert to integers.
        Double value1 = Double.parseDouble(cost_ticket);
        Integer value2 = Integer.parseInt(num_tickets.getText().toString());
        //do the calculation
        Double calculatedValue = (value2*value1);
        //set the value to the textview, to display on screen.
        total_cost = String.format("%.2f", calculatedValue);
        total_cost_view.setText(String.format("%.2f", calculatedValue));
    }
}