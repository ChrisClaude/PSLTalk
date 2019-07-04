package com.claudechrist.premiere_soccer_league_app;

import android.app.DatePickerDialog;
import java.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.michaelmuenzer.android.scrollablennumberpicker.ScrollableNumberPicker;
import com.michaelmuenzer.android.scrollablennumberpicker.ScrollableNumberPickerListener;

public class AddAndEditActivity extends AppCompatActivity {

    Calendar c;
    DatePickerDialog datePickerDialog;
    private Button pickDateBtn;
    private int day;
    private int month;
    private int year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_and_edit);

        Toolbar toolbar = findViewById(R.id.AddToolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_baseline_close);

        final ScrollableNumberPicker verticalNumberPicker = (ScrollableNumberPicker) findViewById(R.id.number_picker_vertical_icons);

        verticalNumberPicker.setListener(new ScrollableNumberPickerListener() {
            @Override
            public void onNumberPicked(int value) {
                Toast.makeText(AddAndEditActivity.this, "number picker picked at value " + value, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Add the check menu icon to the tool bar
     * in AddAndEditActivity
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_menu, menu);

        return true;
    }

    public void pickDate(View view) {
        c = Calendar.getInstance();

        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH) + 1;
        int year = c.get(Calendar.YEAR);

        datePickerDialog = new DatePickerDialog(AddAndEditActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                setDay(dayOfMonth);
                setMonth(month + 1);
                setYear(year + 1);
            }
        }, day, month, year);


        datePickerDialog.show();

    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /*// this method adds the menu to the toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    // here we set a listener to the item created in the menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.search_match:
                Toast.makeText(this, "Search match Item clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.delete_match:
                Toast.makeText(this, "Delete match Item clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.new_match:
                Toast.makeText(this, "New match Item clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }*/

}
