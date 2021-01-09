package com.example.Devina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
            }
        }, 5000);

//        Intent intent = new Intent( MainActivity.this,MainActivity2.class);
////        finish();
//        startActivity(intent);
//
////        final int welcomeScreenDisplay= 3000; // 3000=detik
////        Thread welcomeThread = new Thread(){
////            int wait = 0;
////            @Override
////            public void run (){
////                try{
////                    super.run();
////                    while (wait < welcomeScreenDisplay){
////                        sleep( 100);
////                        wait += 1000;
////                    }
////                }catch (Exception e){
////                    System.out.println("EXc=" + e);
////                }finally {
////                    Intent intent = new Intent( MainActivity.this,MainActivity2.class);
////                    finish();
////                    startActivity(intent);
////                }
////            }
////        };
////        welcomeThread.start();
//    }
    }
}