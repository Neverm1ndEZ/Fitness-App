package com.nevermind.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExerciseListActivity extends AppCompatActivity {

    private TextView txtWelcome;
    private Button btnGetSuggestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);

        txtWelcome = findViewById(R.id.txtWelcome);
        btnGetSuggestion = findViewById(R.id.btnGetSuggestion);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        String gender = intent.getStringExtra("gender");
        String requirement = intent.getStringExtra("requirement");

        String welcomeMessage = "Hello, " + userName + "!\nHere are some exercises for " + requirement + ".";
        txtWelcome.setText(welcomeMessage);

        btnGetSuggestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int age = intent.getIntExtra("age", 0);

                // TODO: Implement logic to display exercise suggestions based on age and requirement
                String suggestionMessage = generateSuggestionMessage(requirement, age);
                txtWelcome.setText(suggestionMessage);
            }
        });
    }

    // Example logic to generate exercise suggestions
    private String generateSuggestionMessage(String requirement, int age) {
        // Customize this method based on your actual logic
        String suggestions = "Here are some exercise suggestions based on your age (" + age + ") and requirement:\n";
        switch (requirement) {
            case "Stress Control":
                suggestions += "1. Yoga\n2. Meditation\n3. Deep Breathing Exercises";
                break;
            case "Lean Muscle Gain":
                suggestions += "1. Weightlifting\n2. High-intensity Interval Training (HIIT)\n3. Protein-rich diet";
                break;
            case "Weight Loss":
                suggestions += "1. Cardio workouts\n2. Healthy diet\n3. Consistent calorie deficit";
                break;
            default:
                suggestions += "No specific suggestions available for this requirement.";
                break;
        }
        return suggestions;
    }
}
