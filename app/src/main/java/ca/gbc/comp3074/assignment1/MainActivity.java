package ca.gbc.comp3074.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  UI objects references
        EditText no_of_hours = findViewById(R.id.no_of_hours);
        EditText hourly_rate = findViewById(R.id.hourly_rate);
        TextView total_pay_value  = findViewById(R.id.total_pay_value);
        TextView tax_value  = findViewById(R.id.tax_value);
        Button calculate_pay_btn = findViewById(R.id.calculate_pay_btn);

        calculate_pay_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double val_pay = 0;
                double val_tax = 0;
                int val_no_of_hours = Integer.parseInt(no_of_hours.getText().toString());
                int val_hourly_rate = Integer.parseInt(hourly_rate.getText().toString());
                if(val_no_of_hours <= 40){
                    val_pay = val_no_of_hours * val_hourly_rate;
                }else{
                    val_pay = (val_no_of_hours - 40) * val_hourly_rate * 1.5 + 40 * val_hourly_rate;
                }
                val_tax = val_pay * 0.18;

                total_pay_value.setText(Double.toString(val_pay));
                tax_value.setText(Double.toString(val_tax));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.about_item:
                Intent start = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(start);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}