/*
 * Created by Swift Harmony on 10/12/2023, 4:03 pm
 * Copyright(c) $today.year.All rights reserved.
 * Last modified 10/12/2023, 10:38 am
 */

package com.example.projectzakat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;  // Import Log
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AboutActivity extends AppCompatActivity {
    Toolbar aboutToolbar;
    Button btnGithub;  // Add TextView variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        aboutToolbar = findViewById(R.id.about_toolbar);
        setSupportActionBar(aboutToolbar);
        getSupportActionBar().setTitle("About");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btnGithub = findViewById(R.id.btnGithub);  // Initialize TextView
        btnGithub.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                openLink("https://github.com/missnurin/ict602_assignment");
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    // Method to open GitHub link
    private void openLink(String url) {
        // Create an Intent to open a web page
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
