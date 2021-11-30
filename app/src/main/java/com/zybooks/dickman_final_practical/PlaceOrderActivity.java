package com.zybooks.dickman_final_practical;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.Toolbar;

public class PlaceOrderActivity extends AppCompatActivity {
    private String full_name;
    private String result;
    private String people;
    private String time;
    private String cost_ticket;
    private EditText num_tickets;
    private int total_cost;
    private EditText total_cost_view;
    private EditText firstName;
    private EditText LastName;
    private RadioGroup time_select_radio_group;
    private RadioButton time_select_early;
    private RadioButton time_select_late;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        cost_ticket = DetailFragment.getCostTicket();
        LastName = findViewById(R.id.submit_Last_name);
        firstName = findViewById(R.id.submit_First_name);
        num_tickets = findViewById(R.id.num_attend_edit_text);
//        total_cost_view = findViewById(R.id.total_cal);
        time_select_radio_group = findViewById(R.id.time_radio_group);
        time_select_early = findViewById(R.id.early_time_radio_button);
        time_select_late = findViewById(R.id.late_time_radio_button);

        time_select_late.setText(DetailFragment.getLateDateTime());
        time_select_early.setText(DetailFragment.getEarlyDateTime());
        cost_ticket = DetailFragment.getCostTicket();

        //people = num_tickets.getText().toString();
        //full_name = firstName.getText().toString() +" "+LastName.getText().toString();

        int checkedId = time_select_radio_group.getCheckedRadioButtonId();
        if (checkedId == R.id.late_time_radio_button) {
            //result = "Name: "+ firstName.getText().toString() +" "+LastName.getText().toString() +"\n" + "Number of tickets: "+ num_tickets.getText().toString() +"\n" + "Cost: $"+cost_ticket+"\n" +"Date: "+ time_select_late.getText().toString() +"\n";
            time = time_select_late.getText().toString();
        } else if (checkedId == R.id.early_time_radio_button) {
            //result = "Name: "+ firstName.getText().toString() +" "+LastName.getText().toString() +"\n" + "Number of tickets: "+ num_tickets.getText().toString() +"\n" + "Cost: $"+cost_ticket+"\n" +"Date: "+ time_select_early.getText().toString() +"\n";
            time = time_select_early.getText().toString();
        }


        Button button = findViewById(R.id.submit_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "Name: "+ firstName.getText().toString() +" "+LastName.getText().toString() +"\n" + "Number of tickets: "+ num_tickets.getText().toString() +"\n" + "Cost: "+cost_ticket+"\n" +"Date: "+ time +"\n";
                Toast.makeText(PlaceOrderActivity.this, result, Toast.LENGTH_LONG).show();
            }
        });
    }

//    public void calculateClick(View view) {
//        // Get how many are attending the party
//        int cost_of_ticket;
//        int total;
//        int numAttend;
//        try {
//            String numAttendStr = num_tickets.getText().toString();
//            numAttend = Integer.parseInt(numAttendStr);
//            cost_of_ticket = Integer.parseInt(cost_ticket);
//        }
//        catch (NumberFormatException ex) {
//            numAttend = 0;
//            cost_of_ticket = 0;
//        }
//        total = (cost_of_ticket * numAttend);
//        total_cost = total;
//        total_cost_view.setText(total);
//    }
}