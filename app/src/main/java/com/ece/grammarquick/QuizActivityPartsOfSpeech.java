package com.ece.grammarquick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivityPartsOfSpeech extends AppCompatActivity {

    private QuizLibraryPartsOfSpeech mQuestionLibrary = new QuizLibraryPartsOfSpeech();
    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button nextTopic;

    private String mAnswer;
    private int mScore=0;
    private int mQuestionNumber=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_parts_of_speech);

        mScoreView=(TextView)findViewById(R.id.score);
        mQuestionView=(TextView)findViewById(R.id.question);
        mButtonChoice1=(Button)findViewById(R.id.choice1);
        mButtonChoice2=(Button)findViewById(R.id.choice2);
        mButtonChoice3=(Button)findViewById(R.id.choice3);
        nextTopic=(Button)findViewById(R.id.nextTopic);
        nextTopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(QuizActivityPartsOfSpeech.this, Number.class);
                startActivity(intent);
            }
        });

        updateQuestion();

        //start button listener code here for button1
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //logic for button goes here
                if(mButtonChoice1.getText()==mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //optional code here
                    Toast.makeText(QuizActivityPartsOfSpeech.this,"Correct!",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(QuizActivityPartsOfSpeech.this,"Wrong!! Correct Answer : "+mAnswer,Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });
        //end of button listener for button1

        //start button listener code here for button2
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //logic for button goes here
                if(mButtonChoice2.getText()==mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //optional code here
                    Toast.makeText(QuizActivityPartsOfSpeech.this,"Correct!",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(QuizActivityPartsOfSpeech.this,"Wrong!! Correct Answer : "+mAnswer,Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });
        //end of button listener for button2

        //start button listener code here for button3
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //logic for button goes here
                if(mButtonChoice3.getText()==mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //optional code here
                    Toast.makeText(QuizActivityPartsOfSpeech.this,"Correct!",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(QuizActivityPartsOfSpeech.this,"Wrong!! Correct Answer : "+mAnswer,Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });
        //end of button listener for button3
    }
    private void updateQuestion(){
        if(mQuestionNumber<mQuestionLibrary.getLength()) {
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));

            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        }
        //else
        //{
        // Toast.makeText(QuizActivitySentence.this, "Test is Over", Toast.LENGTH_SHORT).show();
        //}
    }

    private void updateScore(int point){
        mScoreView.setText(""+mScore);
    }
}
