package com.bkacad.nnt.demothreadd02k11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnStart1, btnStart2;
    private TextView tvNumber;
    private Thread1 thread1;
    private Thread thread2;
    private Handler handler;

    private void initUI(){
        btnStart1 = findViewById(R.id.btn_main_start_thread1);
        tvNumber = findViewById(R.id.tv_main_number);
        btnStart2 = findViewById(R.id.btn_main_start_thread2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        handler = new Handler(getMainLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case 1:
                        int number = (int) msg.obj;
                        tvNumber.setText(String.valueOf(number));
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "Ket thuc", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, msg.obj.toString(), Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        };

        thread1 = new Thread1(handler);
        btnStart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tao luong
                thread1.start();
            }
        });

        thread2 = new Thread(new Thread2(handler));
        btnStart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thread2.start();
            }
        });


    }
}