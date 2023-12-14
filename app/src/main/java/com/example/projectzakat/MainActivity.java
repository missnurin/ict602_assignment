/*
 * *
 *  Created by Prada Calculator on 10/12/2023, 4:03 pm
 *  Copyright(c) $today.year.All rights reserved.
 *  Last modified 10/12/2023, 11:19 am
 * /
 */

package com.example.projectzakat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Toolbar myToolbar;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button calcZakat;
    TextView tvTotVal, tvGoldPay, tvTotZakat;
    EditText etWeight, etGoldVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        etWeight = findViewById(R.id.editTextWeight);
        etGoldVal = findViewById(R.id.editTextGoldVal);

        radioGroup = findViewById(R.id.radioGroup);
        calcZakat = findViewById(R.id.btnCalc);
        calcZakat.setOnClickListener(this);

        tvTotVal = findViewById(R.id.textViewTotVal);
        tvGoldPay = findViewById(R.id.textViewGoldPay);
        tvTotZakat = findViewById(R.id.textViewTotZakat);

    }

    public void onClick(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        String choice = (String) radioButton.getText();

        try {
            double weight = Double.parseDouble(etWeight.getText().toString());
            double goldVal = Double.parseDouble(etGoldVal.getText().toString());
            double totValGold = 0, zPay = 0, totZ = 0;
            if (choice.equalsIgnoreCase("keep")) {
                totValGold = weight * goldVal;
                zPay = (weight - 85) * goldVal;
                if (zPay <= 0) {
                    zPay = 0;
                }
                totZ = zPay * 0.025;
            } else if (choice.equalsIgnoreCase("wear")) {
                totValGold = weight * goldVal;
                zPay = (weight - 200) * goldVal;
                if (zPay <= 0) {
                    zPay = 0;
                }
                totZ = zPay * 0.025;
            }
            tvTotVal.setText("Total value of the gold: RM " + totValGold);
            tvGoldPay.setText("Total Gold Value Zakat Payable: RM" + zPay);
            tvTotZakat.setText("Total Zakat: RM " + totZ);
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "ERROR: Value required. Please provide a valid input!", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.item_share){
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT,"Please visit my github - https://github.com/missnurin/ict602_assignment");
            startActivity(Intent.createChooser(shareIntent,null));

            return true;
        } else if(item.getItemId() == R.id.item_about){
            Intent aboutIntent = new Intent(this, AboutActivity.class);
            startActivity(aboutIntent);

        }
        return  false;
    }
}
