package com.killer.stoyan.safe;

import android.widget.TextView;

/**
 * Created by studente on 15/02/18.
 */

public class updateText extends Thread{
    TextView tv;
    String[] tryes;

    Thread thr= new Thread(update);

    Runnable update = new Runnable() {

    @Override
        public void run() {
            try {
                tv.setText(tryes.toString());
            }
            catch(InterruptedException e){
                System.out.println(clock + "has ended");
                return;
            }

        }
    };
}
