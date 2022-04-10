package com.example.vkiHesaplama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {


    private BreakIterator sonucText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHesapla=(Button) findViewById(R.id.button);
        EditText txtBoy=(EditText) findViewById(R.id.editTextBoy);
        EditText txtKilo=(EditText) findViewById(R.id.editTextKilo);
        TextView sonucText=(TextView) findViewById(R.id.SonucText);

        btnHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double boy= Double.parseDouble(txtBoy.getText().toString());
                double kilo= Double.parseDouble(txtKilo.getText().toString());
                double vki= kilo/Math.pow((boy/100),2);

                String sonuc="";
                if (vki<20.7){
                    sonuc="Zayıf";
                }
                else if (vki>=20.7 && vki<26.4){
                    sonuc="Normal";
                }
                else if (vki>=26.4 && vki<27.8){
                    sonuc="hafif şişman";
                }
                else if (vki>=27.8 && vki<31.1){
                    sonuc="Şisman";
                }
                else if (vki>=31.1 && vki<44.8){
                    sonuc="obez";
                }
                else if (vki>44.9){
                    sonuc="Aşırı obez";
                }
                sonucText.setText(sonuc);

                Intent intent=new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("gönderilen",sonucText.getText().toString());
                startActivity(intent);
            }

        });

    }

    /*public void btnGonder(View v){
        Intent intent=new Intent(getApplicationContext(),MainActivity2.class);
        intent.putExtra("gönderilen",sonucText.getText().toString());
        startActivity(intent);
    }*/


}