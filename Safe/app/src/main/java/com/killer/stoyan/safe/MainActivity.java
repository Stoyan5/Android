package com.killer.stoyan.safe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String PIN;
    private String tryes;
    //private int sentinel;
   // private Runnable textU;
    private TextView tv;

    //Thread thr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PIN="1234";
        tryes="";
 /*       Runnable textU =new Runnable(com.killer.stoyan.safe.textU());
        thr=new Thread(textU);
        PIN[0]=1;
        PIN[1]=2;
        PIN[2]=3;
        PIN[3]=4;
        sentinel=0;*/

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv =findViewById(R.id.textView);
    }

    public void onClick(View view) {
        Intent i = new Intent(this,InActivity.class);
        switch(view.getId()){
            case R.id.button0:
                tryes += "0";
                //tryes[sentinel]=0;
                //sentinel++;
                //thr.run();
                break;
            case R.id.button1:
                tryes += "1";
                //tryes[sentinel]=1;
                //sentinel++;
                //thr.run();
                break;
            case R.id.button2:
                tryes += "2";
                //tryes[sentinel]=2;
                //sentinel++;
                //thr.run();
                break;
            case R.id.button3:
                tryes += "3";
                //tryes[sentinel]=3;
                //sentinel++;
                //thr.run();
                break;
            case R.id.button4:
                tryes += "4";
//                tryes[sentinel]=4;
//                sentinel++;
                break;
            case R.id.button5:
                tryes += "5";
//                tryes[sentinel]=5;
//                sentinel++;
                break;
            case R.id.button6:
                tryes += "6";
//                tryes[sentinel]=6;
//                sentinel++;
                break;
            case R.id.button7:
                tryes += "7";
//                tryes[sentinel]=7;
//                sentinel++;
            case R.id.button8:
                tryes += "8";
//                tryes[sentinel]=8;
//                sentinel++;
                break;
            case R.id.button9:
                tryes += "9";
//                tryes[sentinel]=9;
//                sentinel++;
                break;
            case R.id.delete:
                if(tryes.length()!=0) {
                    tryes = tryes.substring(0, tryes.length() - 1);
//                tryes[sentinel]=null;
//                sentinel--;
                }
                break;
        }
        tv.setText(tryes);
        if(check()){startActivity(i);}
    }
    private boolean check(){
        //boolean isRight=false;
        return tryes.equals(PIN);

   /*    for (int i=0;i<4;i++){
            if(PIN[i]==tryes[i])isRight=true;
            else{
                isRight=false;
                break;
            }
        }*/
        //return isRight;
    }
    //aggiungere se PIN == tryes passare al activity aperto
}

