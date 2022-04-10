package com.example.vkiHesaplama;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        al=findViewById(R.id.textView);
        Intent intent =getIntent();
        String s= intent.getStringExtra("gönderilen");
        al.setText(s);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            NavUtils.navigateUpTo(this,intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}