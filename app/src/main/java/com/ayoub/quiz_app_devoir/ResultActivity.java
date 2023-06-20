/**
 * @author TALBI Ayoub
 * @date 18-06-2023
 */


package com.ayoub.quiz_app_devoir;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView scoreTextView;
    private TextView reponsesTextView;
    private Button revenirAmainButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        scoreTextView = findViewById(R.id.score_text);
        reponsesTextView = findViewById(R.id.les_reponses);
        revenirAmainButton = findViewById(R.id.revenir_button);

        int score = getIntent().getIntExtra("score", 0);
        Parcelable[] parcelables = getIntent().getParcelableArrayExtra("questions");
        Question[] questions = new Question[parcelables.length];
        for (int i = 0; i < parcelables.length; i++) {
            questions[i] = (Question) parcelables[i];
        }

        scoreTextView.setText("Score : " + score + "/" + questions.length);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < questions.length; i++) {
            sb.append("Ques: ").append(questions[i].getQuestion()).append("\n");
            sb.append("Répo: ").append(questions[i].getChoix()[questions[i].getChoixCorrect()]).append("\n");
            sb.append("\n");
        }
        reponsesTextView.setText(sb.toString());

        revenirAmainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}