package com.bkacad.nnt.demothreadd02k11;

import android.os.Handler;
import android.os.Message;

public class Thread2 implements  Runnable{
    private Handler handler;

    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public Thread2(Handler handler){
        this.handler = handler;
    }

    @Override
    public void run() {
        // Random 1 so bat ki 10 lan, sau 3s random 1 lan
        int number = -1;
        try {
            for(int i = 0; i < 10; i++) {
                number = Thread2.getRandomNumber(1000, 2000);
                Message msg = handler.obtainMessage(3);
                msg.obj = number;
                handler.sendMessage(msg);
                Thread.sleep(3000);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
