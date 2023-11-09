// src/your_package_name/ExerciseListActivity.java
package com.nevermind.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExerciseListActivity extends AppCompatActivity {
    private EditText editTextAge;
    private Button btnGetSuggestion;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);

        editTextAge = findViewById(R.id.editTextAge);
        btnGetSuggestion = findViewById(R.id.btnGetSuggestion);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");

        btnGetSuggestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int age = Integer.parseInt(editTextAge.getText().toString());

                // Generate exercise suggestions
                String suggestionMessage = generateExerciseSuggestions(name, age);

                // Display suggestions
                ((TextView) findViewById(R.id.txtWelcome)).setText(suggestionMessage);
            }
        });
    }

    // Method to generate exercise suggestions based on age and other details
    private String generateExerciseSuggestions(String name, int age) {
        StringBuilder suggestions = new StringBuilder("Hello, " + name + "!\nHere are some exercise suggestions based on your age ("
                + age + "):\n");

        // Customize the suggestions based on different age groups or requirements
        if (age < 18) {
            suggestions.append("1. Youth-friendly exercises\n2. Outdoor activities\n3. Fun sports");
        } else if (age >= 18 && age < 40) {
            suggestions.append("1. Cardio workouts\n2. Weight training\n3. Yoga for flexibility");
        } else {
            suggestions.append("1. Low-impact exercises\n2. Stretching routines\n3. Balance exercises");
        }

        return suggestions.toString();
    }
}
