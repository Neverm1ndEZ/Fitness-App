package com.nevermind.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private Spinner spinnerGender, spinnerRequirement;
    private Button btnProceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        spinnerGender = findViewById(R.id.spinnerGender);
        spinnerRequirement = findViewById(R.id.spinnerRequirement);
        btnProceed = findViewById(R.id.btnProceed);

        ArrayAdapter<CharSequence> genderAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderAdapter.add("Male");
        genderAdapter.add("Female");
        spinnerGender.setAdapter(genderAdapter);

        ArrayAdapter<CharSequence> requirementAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        requirementAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        requirementAdapter.add("Stress Control");
        requirementAdapter.add("Lean Muscle Gain");
        requirementAdapter.add("Weight Loss");
        spinnerRequirement.setAdapter(requirementAdapter);

        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString();
                String gender = spinnerGender.getSelectedItem().toString();
                String requirement = spinnerRequirement.getSelectedItem().toString();

                Intent intent = new Intent(MainActivity.this, ExerciseListActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("gender", gender);
                intent.putExtra("requirement", requirement);
                startActivity(intent);
            }
        });
    }
}