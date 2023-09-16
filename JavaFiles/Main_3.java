package com.example.tic_tac_toe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,button12;
    String bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9;
    int flag = 0;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ids();
        Dialog dialog = new Dialog(this);
        dialog.setCancelable(false);
        MediaPlayer music = MediaPlayer.create(MainActivity.this, R.raw.music);
        music.start();
        dialog.setContentView(R.layout.dialog);
        Button dialobtn = dialog.findViewById(R.id.dialbtn);
        dialobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                music.pause();
            }
        });
        dialog.show();




    }




    public void ids(){
        b1=findViewById(R.id.b1);
        button12=findViewById(R.id.button12);
        b2=findViewById(R.id.b2); b3=findViewById(R.id.b3); b4=findViewById(R.id.b4); b5=findViewById(R.id.b5); b6=findViewById(R.id.b6); b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8); b9=findViewById(R.id.b9);
    }
        public void reset(){
        b1.setText("");b2.setText("");b3.setText("");b4.setText("");b5.setText("");b6.setText("");b7.setText("");
            b8.setText("");
            b9.setText("");
            b1.setBackgroundColor(Color.WHITE);
            b2.setBackgroundColor(Color.WHITE);b3.setBackgroundColor(Color.WHITE);
            b4.setBackgroundColor(Color.WHITE);
            b5.setBackgroundColor(Color.WHITE);
            b8.setBackgroundColor(Color.WHITE);b7.setBackgroundColor(Color.WHITE);
            b6.setBackgroundColor(Color.WHITE);b9.setBackgroundColor(Color.WHITE);
            flag=0;

            count=0;
        }
    public void resets(View view){
        b1.setText("");b2.setText("");b3.setText("");b4.setText("");b5.setText("");b6.setText("");b7.setText("");
        b8.setText("");
        b9.setText("");
        flag=0;
        b1.setBackgroundColor(Color.WHITE);
        b2.setBackgroundColor(Color.WHITE);b3.setBackgroundColor(Color.WHITE);
        b4.setBackgroundColor(Color.WHITE);b9.setBackgroundColor(Color.WHITE);
        b5.setBackgroundColor(Color.WHITE);
        b8.setBackgroundColor(Color.WHITE);b7.setBackgroundColor(Color.WHITE);
        b6.setBackgroundColor(Color.WHITE);


        count=0;

    }
    public void game(View view){



        Button sensbtn = (Button) view;
        if (sensbtn.getText().toString().equals("")) {
            count++;
            if (flag == 0) {
                sensbtn.setText("X");
               sensbtn.setBackgroundColor(Color.RED);
               sensbtn.setTextColor(Color.WHITE);
                flag = 1;

            } else if (flag == 1) {
                sensbtn.setText("O");
                sensbtn.setBackgroundColor(Color.GREEN);
                sensbtn.setTextColor(Color.BLACK);

                flag = 0;

            }

            if (count > 4) {
                bt1=b1.getText().toString(); bt5=b5.getText().toString();bt6=b6.getText().toString();
                bt2=b2.getText().toString();bt3=b3.getText().toString();bt4=b4.getText().toString();
                bt7=b7.getText().toString();bt8=b8.getText().toString();bt9=b9.getText().toString();
                if (bt1.equals(bt2) && bt2.equals(bt3) && !bt1.equals("")) {
                    Snackbar.make(b1,"Winner is "+ bt2,Snackbar.LENGTH_LONG).show();
                    reset();
                } else if (bt4.equals(bt5) && bt5.equals(bt6) && !bt5.equals("")) {
                    Snackbar.make(b1,"Winner is "+ bt5,Snackbar.LENGTH_LONG).show();
                    reset();
                } else if (bt7.equals(bt8) && bt8.equals(bt9) && !bt7.equals("")) {
                    Snackbar.make(b1,"Winner is "+ bt9,Snackbar.LENGTH_LONG).show();
                    reset();
                } else if (bt1.equals(bt4) && bt4.equals(bt7) && !bt1.equals("")) {
                    Snackbar.make(b1,"Winner is "+ bt4,Snackbar.LENGTH_LONG).show();
                    reset();
                } else if (bt2.equals(bt5) && bt5.equals(bt8) && !bt2.equals("")) {
                    Snackbar.make(b1,"Winner is "+ bt5,Snackbar.LENGTH_LONG).show();
                    reset();
                } else if (bt3.equals(bt6) && bt6.equals(bt9) && !bt3.equals("")) {
                    Snackbar.make(b1,"Winner is "+ bt3,Snackbar.LENGTH_LONG).show();
                    reset();
                } else if (bt1.equals(bt5) && bt5.equals(bt9) && !bt1.equals("")) {
                    Snackbar.make(b1,"Winner is "+ bt5,Snackbar.LENGTH_LONG).show();
                    reset();
                } else if (bt3.equals(bt5) && bt5.equals(bt7) && !bt3.equals("")) {
                    Snackbar.make(b1,"Winner is "+ bt5,Snackbar.LENGTH_LONG).show();
                    reset();

                } else if (count==9) {
                    Snackbar.make(b1,"Draw",Snackbar.LENGTH_LONG).show();
                    reset();
                }

            }


            }
        }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alrt = new AlertDialog.Builder(this);
        alrt.setTitle("Exit ?");
        alrt.setMessage("Do you want to Exit?");
        alrt.setIcon(R.drawable.baseline_exit_to_app_24);
        alrt.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Welcome Back", Toast.LENGTH_SHORT).show();
            }
        });
        alrt.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alrt.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.super.onBackPressed();
            }
        });
        alrt.show();
    }
}