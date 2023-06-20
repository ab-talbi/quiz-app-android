/**
 * @author TALBI Ayoub
 * @date 18-06-2023
 */

package com.ayoub.quiz_app_devoir;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private static final int TAILLE_QUESTIONS = 10;
    private TextView questionTextView;
    private RadioGroup optionsRadioGroup;
    private Button envoyerButton;

    private Question[] questions;
    private int questionCorranteId = 0;
    private int score = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionTextView = findViewById(R.id.question);
        optionsRadioGroup = findViewById(R.id.options_radio_group);
        envoyerButton = findViewById(R.id.envoyer);

        questions = getQuestions();

        afficherLaQuestion();

        envoyerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifierLaReponse();
            }
        });
    }

    /**
     * Pour l'affichage de la question avec ses choix
     */
    private void afficherLaQuestion() {
        Question questionCourrante = questions[questionCorranteId];

        questionTextView.setText(questionCourrante.getQuestion());

        optionsRadioGroup.removeAllViews();

        String[] choix = questionCourrante.getChoix();
        RadioButton[] radioButtons = new RadioButton[choix.length];
        for (int i = 0; i < choix.length; i++) {
            radioButtons[i] = new RadioButton(this);
            radioButtons[i].setText(choix[i]);
            radioButtons[i].setId(i);
            optionsRadioGroup.addView(radioButtons[i]);
        }
    }

    /**
     * Pour la verification de la reponse
     */
    private void verifierLaReponse() {
        int selectedId = optionsRadioGroup.getCheckedRadioButtonId();
        if (selectedId == -1) {
            //Rien est selectionné
            return;
        }

        Question questionCourrante = questions[questionCorranteId];
        if (selectedId == questionCourrante.getChoixCorrect()) {
            //la reponse est juste, donc on incremente le score
            score++;
        }

        questionCorranteId++;
        if (questionCorranteId < questions.length) {
            //il reste des questions
            afficherLaQuestion();
        } else {
            //la fin des questions donc on va afficher le score...
            afficherLeResult();
        }
    }

    /**
     * Pour l'affichage du résultat
     */
    private void afficherLeResult() {
        //j'envoi le score et les questions avec ses reponses à ResultActivity
        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
        intent.putExtra("score", score);
        intent.putExtra("questions", questions);
        startActivity(intent);
        finish();
    }

    /**
     * La definition des questions avec les choix et le choix correcte
     * @return une liste des questions de type Question
     */
    private Question[] getQuestions() {
        Question[] questions = new Question[TAILLE_QUESTIONS];

        // Question 1
        String question1 = "React est principalement utilisé pour construire ___.";
        String[] choix1 = {"Base de données", "Connectivité", "Interface utilisateur", "Design Platform"};
        int choixCorrect1 = 2;
        questions[0] = new Question(question1, choix1, choixCorrect1);

        // Question 2
        String question2 = "Les méthodes de cycle de vie sont principalement utilisées pour ___.";
        String[] choix2 = {"Garder une trace de l'historique des événements", "Améliorer les composants", "Libérer des ressources", "Aucune de ces réponses"};
        int choixCorrect2 = 3;
        questions[1] = new Question(question2, choix2, choixCorrect2);

        // Question 3
        String question3 = "___ peut être fait alors que plusieurs éléments doivent être retournés à partir d'un composant.";
        String[] choix3 = {"Abstraction", "Packing", "Insulation", "Wrapping"};
        int choixCorrect3 = 3;
        questions[2] = new Question(question3, choix3, choixCorrect3);

        // Question 4
        String question4 = "Quelle est la bonne façon d'accéder à une fonction fetch() à partir d'un élément h1 dans JSX?";
        String[] choix4 = {"<h1>{fetch()}</h1>", "<h1>${fetch()}</h1>", "<h1>{fetch}</h1>", "<h1>${fetch}</h1>"};
        int choixCorrect4 = 2;
        questions[3] = new Question(question4, choix4, choixCorrect4);

        // Question 5
        String question5 = "Laquelle des méthodes suivantes dans un composant React doit être remplacée pour empêcher la mise à jour du composant?";
        String[] choix5 = {"willComponentUpdate", "shouldComponentUpdate", "componentDidUpdate", "componentDidMount"};
        int choixCorrect5 = 1;
        questions[4] = new Question(question5, choix5, choixCorrect5);

        // Question 6
        String question6 = "Qu'est-ce qui est utilisé pour transmettre des données à un composant depuis l'extérieur?";
        String[] choix6 = {"setState", "render with arguments", "PropTypes", "props"};
        int choixCorrect6 = 3;
        questions[5] = new Question(question6, choix6, choixCorrect6);

        // Question 7
        String question7 = "Laquelle des méthodes suivantes dans un composant React est appelée après le premier rendu du composant?";
        String[] choix7 = {"componentDidUpdate", "componentDidMount", "componentMounted", "componentUpdated"};
        int choixCorrect7 = 1;
        questions[6] = new Question(question7, choix7, choixCorrect7);

        // Question 8
        String question8 = "Parmi les propositions suivantes, laquelle est la syntaxe correcte pour un gestionnaire d'événements de clic de bouton foo ?";
        String[] choix8 = {"<button onclick={this.foo()}>", "<button onclick={this.foo}>", "<button onClick={this.foo()}>", "<button onClick={this.foo}>"};
        int choixCorrect8 = 3;
        questions[7] = new Question(question8, choix8, choixCorrect8);

        // Question 9
        String question9 = "Que se passera-t-il si vous appelez setState() dans la méthode render()?";
        String[] choix9 = {"Une sortie répétitive apparaît à l'écran", "Duplicate key error", "Stack overflow error", "Il ne se passe rien"};
        int choixCorrect9 = 2;
        questions[8] = new Question(question9, choix9, choixCorrect9);

        // Question 10
        String question10 = "Comment écrivez-vous un style en ligne qui spécifie la font-size:12px et color:red; dans JSX ?";
        String[] choix10 = {"style={{font-size:12,color:'red'}}", "style={{fontSize:'12px',color:'red'}}", "style={fontSize:'12px',color:'red'}", "style={{font-size:12px,color:'red'}}"};
        int choixCorrect10 = 1;
        questions[9] = new Question(question10, choix10, choixCorrect10);

        return questions;
    }
}