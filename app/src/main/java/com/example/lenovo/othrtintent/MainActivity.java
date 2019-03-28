package com.example.lenovo.othrtintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button call,sms,whatsapp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText= (EditText)findViewById(R.id.number);
        call=(Button)findViewById(R.id.call);
        sms=(Button)findViewById(R.id.sms);
        whatsapp=(Button)findViewById(R.id.wa);


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String number= editText.getText().toString();
            String dial = "tel:"+number;
            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
            }
        });
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String number= editText.getText().toString();
            String sms = "smsto:"+number;
            Intent smsIntent =  new Intent(Intent.ACTION_SENDTO,Uri.parse(sms));
            smsIntent.putExtra("sms_body","Welcome to Edufect");
            startActivity(smsIntent);


            }
        });
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number= editText.getText().toString();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.whatsapp");

                startActivity(sendIntent);

            }
        });

    }
}
