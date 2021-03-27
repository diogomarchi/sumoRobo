package com.example.sumorobo;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;


public class MainActivity extends AppCompatActivity {


    private Button bEsquerda, bDireita, bCima, bBaixo;
    private TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bEsquerda = findViewById(R.id.bEsquerdaID);
        bDireita = findViewById(R.id.bDireitaID);
        bCima = findViewById(R.id.bCimaID);
        bBaixo = findViewById(R.id.bBaixoID);
        titulo = findViewById(R.id.textView);

        bEsquerda.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    titulo.setVisibility(View.INVISIBLE);
                    return false;
                }else{
                    titulo.setVisibility(View.VISIBLE);
                    return true;
                }
            }
        });



        bDireita.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    titulo.setVisibility(View.INVISIBLE);
                    return false;
                }else{
                    titulo.setVisibility(View.VISIBLE);
                    return true;
                }
            }
        });
        bCima.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    titulo.setVisibility(View.INVISIBLE);
                    return false;
                }else{
                    titulo.setVisibility(View.VISIBLE);
                    return true;
                }
            }
        });
        bBaixo.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    titulo.setVisibility(View.INVISIBLE);
                    return false;
                }else{
                    titulo.setVisibility(View.VISIBLE);
                    return true;
                }
            }
        });

    }


/*
    Button down = (Button) findViewById(R.id.bBaixo);
    down.setOnLongClickListener(new OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            Toast toast = Toast.makeText(getApplicationContext(), "TESTANDO", Toast.LENGTH_SHORT);
            toast.show();
            return true;
        }
    });
    */


/*
    public void onClickDireita (View v){
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                View.OnLongClickListener
                Toast toast = Toast.makeText(getApplicationContext(), "TESTANDO", Toast.LENGTH_SHORT);
                toast.show();
            case MotionEvent.ACTION_UP:
                Toast toast2 = Toast.makeText(getApplicationContext(), "TESTANDO", Toast.LENGTH_SHORT);
                toast2.show();
        }
    }


    public void onClickEsquerda (MotionEvent event){
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Toast toast = Toast.makeText(getApplicationContext(), "TESTANDO", Toast.LENGTH_SHORT);
                toast.show();
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
        }
    }


    public void onClickBaixo (MotionEvent event){
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Toast toast = Toast.makeText(getApplicationContext(), "TESTANDO", Toast.LENGTH_SHORT);
                toast.show();
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
        }
    }


    public void onClickCima (MotionEvent event){
        Toast toast = Toast.makeText(getApplicationContext(), "TESTANDO", Toast.LENGTH_SHORT);
        toast.show();
    }
    */





}

