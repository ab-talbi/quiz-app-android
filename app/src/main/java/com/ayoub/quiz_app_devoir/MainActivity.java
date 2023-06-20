/**
 * @author TALBI Ayoub
 * @date 18-06-2023
 */


package com.ayoub.quiz_app_devoir;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button commencerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        commencerButton = findViewById(R.id.commencerButton);
        commencerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commencer_le_quiz();
            }
        });
    }

    private void commencer_le_quiz() {
        Intent intent = new Intent(MainActivity.this, QuizActivity.class);
        startActivity(intent);
    }
}