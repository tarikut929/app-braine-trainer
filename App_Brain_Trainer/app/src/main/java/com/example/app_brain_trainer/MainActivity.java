package com.example.app_brain_trainer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    EditText NUMberOfQuestion;
    EditText score;
    EditText gameover;

    Button play , A , B , C , D , add , sub , mul , div;

    CountDownTimer countDownTimer;

    TextView correct,question,countprogress;

    MediaPlayer mediaPlayer1 , mediaPlayer2 , mediaPlayer3 , mediaPlayer4 , mediaPlayer5;

    ProgressBar progressBar;

    String chooseA , chooseB , chooseC , chooseD ,scoreVstotal , operator = "+";

    int Answeri;

    int count = 0 , scores = 0 , totalquestion = 0,counttimer = 60 , randomincrease = 25 , topRandom = 30 , randomincreasemul = 4 , topRandommul = 8;

    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        NUMberOfQuestion = findViewById(R.id.editText1);
        score = findViewById(R.id.score);
        correct = findViewById(R.id.correct);
        play = findViewById(R.id.play);
        question = findViewById(R.id.question);
        gameover = findViewById(R.id.gameover);
//        gridLayout = findViewById(R.id.gridLayout);
        mediaPlayer1 =  MediaPlayer.create(this,R.raw.gameover);
        mediaPlayer2 = MediaPlayer.create(this,R.raw.jump);
        mediaPlayer3 = MediaPlayer.create(this,R.raw.finish);
        mediaPlayer4 = MediaPlayer.create(this,R.raw.play);
        mediaPlayer5 = MediaPlayer.create(this,R.raw.death);

        progressBar = findViewById(R.id.progress);
        progressBar.setMax(60);
        progressBar.setProgress(60);
        countprogress = findViewById(R.id.countprogress);
        progressBar.setVisibility(View.INVISIBLE);


        A = findViewById(R.id.A);
        B = findViewById(R.id.B);
        C = findViewById(R.id.C);
        D = findViewById(R.id.D);

        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);

        random = new Random();
        NUMberOfQuestion.setEnabled(false);
        NUMberOfQuestion.setTextColor(0xFF000000);
        correct.setVisibility(View.INVISIBLE);

        A.setVisibility(View.INVISIBLE);
        B.setVisibility(View.INVISIBLE);
        C.setVisibility(View.INVISIBLE);
        D.setVisibility(View.INVISIBLE);

        add.setVisibility(View.INVISIBLE);
        sub.setVisibility(View.INVISIBLE);
        mul.setVisibility(View.INVISIBLE);
        div.setVisibility(View.INVISIBLE);

        NUMberOfQuestion.setVisibility(View.INVISIBLE);
        score.setVisibility(View.INVISIBLE);
        question.setText("Math Game");
        question.setVisibility(View.VISIBLE);
        play.setVisibility(View.VISIBLE);



    }
    public void operation(View view){
        if(view.getId() == R.id.add){
            operator = "+";
            add.setVisibility(view.INVISIBLE);
            sub.setVisibility(view.INVISIBLE);
            mul.setVisibility(view.INVISIBLE);
            div.setVisibility(view.INVISIBLE);
            play.setVisibility(view.VISIBLE);
            gameover.setVisibility(view.INVISIBLE);
            correct.setVisibility(view.INVISIBLE);
            question.setText("Ready!");

            choose();
            play.setVisibility(view.INVISIBLE);
            progressBar.setVisibility(view.VISIBLE);
            correct.setVisibility(view.INVISIBLE);
            score.setText("0/0");
            countprogress.setVisibility(view.VISIBLE);
//        gridLayout.setVisibility(view.VISIBLE);
            gameover.setVisibility(view.INVISIBLE);
            NUMberOfQuestion.setText("1");
            question.setVisibility(view.VISIBLE);

            score.setVisibility(view.VISIBLE);
            NUMberOfQuestion.setVisibility(view.VISIBLE);

            A.setVisibility(View.VISIBLE);
            B.setVisibility(View.VISIBLE);
            C.setVisibility(View.VISIBLE);
            D.setVisibility(View.VISIBLE);

            timecounter();

        }
        else if(view.getId() == R.id.sub){
            operator = "-";
            add.setVisibility(view.INVISIBLE);
            sub.setVisibility(view.INVISIBLE);
            mul.setVisibility(view.INVISIBLE);
            div.setVisibility(view.INVISIBLE);

            choose();
            play.setVisibility(view.INVISIBLE);
            progressBar.setVisibility(view.VISIBLE);
            correct.setVisibility(view.INVISIBLE);
            score.setText("0/0");
            countprogress.setVisibility(view.VISIBLE);
//        gridLayout.setVisibility(view.VISIBLE);
            gameover.setVisibility(view.INVISIBLE);
            NUMberOfQuestion.setText("1");

            score.setVisibility(view.VISIBLE);
            NUMberOfQuestion.setVisibility(view.VISIBLE);
            question.setVisibility(view.VISIBLE);

            A.setVisibility(View.VISIBLE);
            B.setVisibility(View.VISIBLE);
            C.setVisibility(View.VISIBLE);
            D.setVisibility(View.VISIBLE);

            timecounter();

        }
        else if(view.getId() == R.id.mul){
            operator = "x";
            add.setVisibility(view.INVISIBLE);
            sub.setVisibility(view.INVISIBLE);
            mul.setVisibility(view.INVISIBLE);
            div.setVisibility(view.INVISIBLE);

            choose();
            play.setVisibility(view.INVISIBLE);
            progressBar.setVisibility(view.VISIBLE);
            correct.setVisibility(view.INVISIBLE);
            score.setText("0/0");
            countprogress.setVisibility(view.VISIBLE);
//        gridLayout.setVisibility(view.VISIBLE);
            gameover.setVisibility(view.INVISIBLE);
            NUMberOfQuestion.setText("1");

            score.setVisibility(view.VISIBLE);
            NUMberOfQuestion.setVisibility(view.VISIBLE);
            question.setVisibility(view.VISIBLE);


            A.setVisibility(View.VISIBLE);
            B.setVisibility(View.VISIBLE);
            C.setVisibility(View.VISIBLE);
            D.setVisibility(View.VISIBLE);

            timecounter();

        }
        else if(view.getId() == R.id.div){
            operator = "/";
            add.setVisibility(view.INVISIBLE);
            sub.setVisibility(view.INVISIBLE);
            mul.setVisibility(view.INVISIBLE);
            div.setVisibility(view.INVISIBLE);

            choose();
            play.setVisibility(view.INVISIBLE);
            progressBar.setVisibility(view.VISIBLE);
            correct.setVisibility(view.INVISIBLE);
            score.setText("0/0");
            countprogress.setVisibility(view.VISIBLE);
//        gridLayout.setVisibility(view.VISIBLE);
            gameover.setVisibility(view.INVISIBLE);
            NUMberOfQuestion.setText("1");

            score.setVisibility(view.VISIBLE);
            NUMberOfQuestion.setVisibility(view.VISIBLE);
            question.setVisibility(view.VISIBLE);


            A.setVisibility(View.VISIBLE);
            B.setVisibility(View.VISIBLE);
            C.setVisibility(View.VISIBLE);
            D.setVisibility(View.VISIBLE);

            timecounter();
        }
    }
    public void timecounter(){
        if (count == 0) {
            countDownTimer = new CountDownTimer(1000000, 1000) {
                public void onTick(long millisUntilFinished) {

                    counttimer--;
                    progressBar.setProgress(counttimer);
                    countprogress.setText(Integer.toString(counttimer) + "s");
                    count = 1;

                    if (counttimer > 20) {
                        mediaPlayer4.start();
                    }


                    if (counttimer <= 20) {
                        mediaPlayer1.start();
                        mediaPlayer4.pause();
                    }

                    if (counttimer <= 0) {
                        onFinish();
                        cancel();
                    }

                }

                public void onFinish() {

                    mediaPlayer1.pause();
                    mediaPlayer2.pause();
                    mediaPlayer4.pause();
                    mediaPlayer5.pause();
                    mediaPlayer3.start();

                    topRandom = 30;
                    randomincrease = 25;

                    topRandommul = 4;
                    randomincreasemul = 8;

                    counttimer = 60;
                    count = 0;
                    play.setText("playAgain");
                    progressBar.setVisibility(View.INVISIBLE);
                    correct.setText("Your Score: " + scoreVstotal);
                    scores = 0;
                    totalquestion = 0;
                    gameover.setVisibility(View.VISIBLE);
                    countprogress.setVisibility(View.INVISIBLE);


                    play.setVisibility(View.VISIBLE);
                    gameover.setVisibility(View.INVISIBLE);
                    correct.setVisibility(View.INVISIBLE);



                    A.setVisibility(View.INVISIBLE);
                    B.setVisibility(View.INVISIBLE);
                    C.setVisibility(View.INVISIBLE);
                    D.setVisibility(View.INVISIBLE);

                    NUMberOfQuestion.setVisibility(View.INVISIBLE);
                    score.setVisibility(View.INVISIBLE);
                    correct.setVisibility(View.VISIBLE);

                    question.setText("Math Game");
                    question.setVisibility(View.VISIBLE);
                }
            }.start();

        }
    }
    public void play(final View view){

        add.setVisibility(View.VISIBLE);
        sub.setVisibility(View.VISIBLE);
        mul.setVisibility(View.VISIBLE);
        div.setVisibility(View.VISIBLE);
        play.setVisibility(view.INVISIBLE);
        gameover.setVisibility(view.INVISIBLE);
        question.setText("Ready!");
        question.setVisibility(view.VISIBLE);
        correct.setVisibility(view.INVISIBLE);

    }
    public void choose(){

        int indexnum1 = random.nextInt(topRandom) + randomincrease;
        int indexnum2 = random.nextInt(topRandom) + randomincrease;

        if(indexnum1 < indexnum2){
            int x = indexnum1;
            indexnum1 = indexnum2;
            indexnum2 = x ;
        }
        int i = totalquestion;
        if(operator.equals("/")){

            indexnum2 = random.nextInt(6 + i) + i ;
            if(indexnum2 == 0){
                indexnum2 = indexnum2 + 6 + random.nextInt(3);
            }
            int x = random.nextInt(6+i) + 1;
            indexnum1 = x * indexnum2;


        }

        if(operator.equals("x")){
            indexnum1 = random.nextInt(topRandommul) + randomincreasemul;
            indexnum2 = random.nextInt(topRandommul) + randomincreasemul;
        }

        String number1 = String.valueOf(indexnum1);
        String number2 = String.valueOf(indexnum2);
        String quesstion = number1 + "+" + number2;
        if(operator.equals("+")){
            quesstion = number1 + " + " + number2;
            question.setText(quesstion);
        }
        else if(operator.equals("x")){
            quesstion = number1 + " x " + number2;
            question.setText(quesstion);
        }

        else if(operator.equals("-")){
            quesstion = number1 + " - " + number2;
            question.setText(quesstion);
        }
        else if(operator.equals("/")){
            quesstion = number1 + " / " + number2;
            question.setText(quesstion);
        }

        int ran1 , ran2 , ran3;
        ran1 = random.nextInt(15);
        ran2 = random.nextInt(15);
        ran3 = random.nextInt(15);

        boolean check = true;
        while(check){
            if(ran1 == ran2){
                ran2 = ran2 + 5;
            }
            if(ran1 == ran3){
                ran3 = ran2 + 5;
            }
            if(ran2 == ran3){
                ran3 = ran3 + 5;
            }
            if(ran1==0){
                ran1 = ran1 + 3;
            }
            if(ran2==0){
                ran2 = ran2 + 3;
            }
            if(ran3==0){
                ran3 = ran3 + 3;
            }
            if(ran1!=ran2 && ran2 != ran3){
                check = false;
            }
        }

        if(operator.equals("+")){
            Answeri = indexnum1 + indexnum2;
        }
        else if(operator.equals("x")){
            Answeri = indexnum1 * indexnum2;
        }
        else if(operator.equals("-")){
            Answeri = indexnum1 - indexnum2;
        }
        else if(operator.equals("/")){
            Answeri = indexnum1 / indexnum2;
        }

        ArrayList<Integer> chooses = new ArrayList<>();
        chooses.add(Answeri);

        int k = random.nextInt(4)+2;
        if(Answeri > 35){

            if(k%2 == 0){
                chooses.add(Answeri - 10);
                chooses.add(Answeri + 20);
                chooses.add(Answeri + 30);
            }
            else if(k%3 == 0){
                chooses.add(Answeri + 10);
                chooses.add(Answeri + 20);
                chooses.add(Answeri + 30);
            }
            else if(k%4 == 0){
                chooses.add(Answeri - 10);
                chooses.add(Answeri - 20);
                chooses.add(Answeri + 30);
            }
            else if(k%5 == 0){
                chooses.add(Answeri - 10);
                chooses.add(Answeri - 20);
                chooses.add(Answeri - 30);
            }

        }
        else{
            chooses.add(Answeri + ran1);
            chooses.add(Answeri + ran2);
            chooses.add(Answeri + ran3);
        }


        int indexchooseA = random.nextInt(4);
        chooseA = String.valueOf(chooses.get(indexchooseA));
        chooses.remove(chooses.get(indexchooseA));

        int indexchooseB = random.nextInt(3);
        chooseB = String.valueOf(chooses.get(indexchooseB));
        chooses.remove(chooses.get(indexchooseB));

        int indexchooseC = random.nextInt(2);
        chooseC = String.valueOf(chooses.get(indexchooseC));
        chooses.remove(chooses.get(indexchooseC));

        chooseD = String.valueOf(chooses.get(0));

        A.setText(chooseA);
        B.setText(chooseB);
        C.setText(chooseC);
        D.setText(chooseD);

        scoreVstotal = String.valueOf(scores) + "/" + String.valueOf(totalquestion);

        NUMberOfQuestion.setText( Integer.toString(totalquestion+1));

        score.setText(scoreVstotal);


    }
    public void chooseA(View view){
        if(count==1){
            totalquestion++;
            String Answers = String.valueOf(Answeri);
            if(chooseA.equals(Answers)){
                topRandom = topRandom + 20;
                randomincrease = randomincrease + 20;
                topRandommul = topRandommul + 2;
                randomincreasemul = randomincreasemul + 2;

                correct.setText("Correct!");
                correct.setVisibility(View.VISIBLE);
                scores++;
                counttimer = counttimer + 2;
                mediaPlayer2.start();
            }else{
                mediaPlayer5.start();
                correct.setText("Wrong!");
                correct.setVisibility(View.VISIBLE);
                if(counttimer > 2){
                    counttimer = counttimer - 2;
                }else{
                    counttimer = 0;

                }
            }
            choose();
        }

    }
    public void chooseB(View view){

        if(count==1){
            totalquestion++;
            String AnswerS = String.valueOf(Answeri);
            if(chooseB.equals(AnswerS)){
                topRandom = topRandom + 20;
                randomincrease = randomincrease + 20;
                topRandommul = topRandommul + 2;
                randomincreasemul = randomincreasemul + 2;
                correct.setText("Correct!");
                correct.setVisibility(View.VISIBLE);
                scores++;
                counttimer = counttimer + 2;
                mediaPlayer2.start();
            }else{
                mediaPlayer5.start();
                correct.setText("Wrong!");
                correct.setVisibility(View.VISIBLE);
                if(counttimer > 2){
                    counttimer = counttimer - 2;
                }else{
                    counttimer = 0;
                }
            }
            choose();
        }

    }
    public void chooseC(View view){

        if(count==1){
            totalquestion++;
            String AnswerS = String.valueOf(Answeri);
            if(chooseC.equals(AnswerS)){
                topRandom = topRandom + 20;
                randomincrease = randomincrease + 20;
                topRandommul = topRandommul + 2;
                randomincreasemul = randomincreasemul + 2;
                correct.setText("Correct!");
                correct.setVisibility(View.VISIBLE);
                scores++;
                counttimer = counttimer + 2;
                mediaPlayer2.start();
            }else{
                mediaPlayer5.start();
                correct.setText("Wrong!");
                correct.setVisibility(View.VISIBLE);
                if(counttimer > 2){
                    counttimer = counttimer - 2;
                }else{
                    counttimer = 0;
                }
            }
            choose();
        }

    }
    public void chooseD(View view){

        if(count==1){
            totalquestion++;
            String AnswerS = String.valueOf(Answeri);
            if(chooseD.equals(AnswerS)){
                topRandom = topRandom + 20;
                randomincrease = randomincrease + 20;
                topRandommul = topRandommul + 2;
                randomincreasemul = randomincreasemul + 2;
                correct.setText("Correct!");
                correct.setVisibility(View.VISIBLE);
                scores++;
                counttimer = counttimer + 2;
                mediaPlayer2.start();
            }else{
                mediaPlayer5.start();
                correct.setText("Wrong!");
                correct.setVisibility(View.VISIBLE);
                if(counttimer > 2){
                    counttimer = counttimer - 2;
                }else{
                    counttimer = 0;
                }
            }
            choose();
        }

    }

}