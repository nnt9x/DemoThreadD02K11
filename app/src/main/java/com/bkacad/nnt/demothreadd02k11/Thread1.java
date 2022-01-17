package com.bkacad.nnt.demothreadd02k11;

import android.icu.util.Measure;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class Thread1 extends Thread{

    private Handler handler;

    public Thread1(Handler handler){
        this.handler = handler;
    }
    @Override
    public void run() {
        super.run();
        for(int i = 1; i <= 100; i++){
            try {
//                Log.d("Count", "count: "+i);
                Thread.sleep(100);
                Message msg = handler.obtainMessage(1);
                msg.obj = i;
                handler.sendMessage(msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            Message msgFinish = handler.obtainMessage(2);
            // Quy uoc what = 2 : ket thuc

        }
        handler.sendEmptyMessage(2);
    }
}
