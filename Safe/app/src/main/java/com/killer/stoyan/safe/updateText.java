package com.killer.stoyan.safe;

import android.widget.TextView;

/**
 * Created by studente on 15/02/18.
 */

public class updateText extends Thread {
    TextView tv;
    String[] tryes;

    updateText(TextView tv, String[] tryes) {
        this.tv = tv;
        this.tryes = tryes;
    }

    public void run() {
        tv.setText(tryes[].);
    }
}

    public static void main(String args[]) {
        (new HelloThread()).start();
    }

}