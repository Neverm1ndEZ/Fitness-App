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

    private Spinner spinnerName, spinnerGender, spinnerRequirement;
    private EditText editTextAge;
    private Button btnProceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerName = findViewById(R.id.spinnerName);
        spinnerGender = findViewById(R.id.spinnerGender);
        spinnerRequirement = findViewById(R.id.spinnerRequirement);
        editTextAge = findViewById(R.id.editTextAge);
        btnProceed = findViewById(R.id.btnProceed);

        // Define arrays directly in the code
        ArrayAdapter<CharSequence> nameAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        nameAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nameAdapter.add("John");
        nameAdapter.add("Jane");
        // Add more names as needed
        spinnerName.setAdapter(nameAdapter);

        ArrayAdapter<CharSequence> genderAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderAdapter.add("Male");
        genderAdapter.add("Female");
        // Add more genders as needed
        spinnerGender.setAdapter(genderAdapter);

        ArrayAdapter<CharSequence> requirementAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        requirementAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        requirementAdapter.add("Stress Control");
        requirementAdapter.add("Lean Muscle Gain");
        requirementAdapter.add("Weight Loss");
        // Add more requirements as needed
        spinnerRequirement.setAdapter(requirementAdapter);

        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int age = Integer.parseInt(editTextAge.getText().toString());
                String userName = spinnerName.getSelectedItem().toString();
                String gender = spinnerGender.getSelectedItem().toString();
                String requirement = spinnerRequirement.getSelectedItem().toString();

                Intent intent = new Intent(MainActivity.this, ExerciseListActivity.class);
                intent.putExtra("userName", userName);
                intent.putExtra("gender", gender);
                intent.putExtra("requirement", requirement);
                intent.putExtra("age", age);
                startActivity(intent);
            }
        });
    }
}
