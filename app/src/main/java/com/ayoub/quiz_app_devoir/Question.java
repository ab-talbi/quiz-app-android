/**
 * @author TALBI Ayoub
 * @date 18-06-2023
 */


package com.ayoub.quiz_app_devoir;

import android.os.Parcel;
import android.os.Parcelable;

//j'utulise Parcelable pour avoir la possibilité d'utilisé la classe Question entre les activitées
public class Question implements Parcelable {
    private String question;
    private String[] choix;
    private int choixCorrect;

    public Question(String question, String[] choix, int choixCorrect) {
        this.question = question;
        this.choix = choix;
        this.choixCorrect = choixCorrect;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getChoix() {
        return choix;
    }

    public int getChoixCorrect() {
        return choixCorrect;
    }

    // pour parcelable implimentation
    protected Question(Parcel in) {
        question = in.readString();
        choix = in.createStringArray();
        choixCorrect = in.readInt();
    }

    public static final Parcelable.Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeStringArray(choix);
        dest.writeInt(choixCorrect);
    }
}