package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textView=findViewById(R.id.textView2);
        Button btn=findViewById(R.id.button);
        int num= (int) (Math.random()*(100)+0);
        textView.setText(String.valueOf(num));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(getIntent().getStringExtra("NAME"),num);
            }
        });
    }

    private void shareData(String name,int num){
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType(("text/plain"));
        i.putExtra(Intent.EXTRA_SUBJECT,name+"Check Your Lucky Number");
        i.putExtra(Intent.EXTRA_TEXT,"Your Luck Number Is "+num);
        startActivity(Intent.createChooser(i,"select the app you want"));
    }
}