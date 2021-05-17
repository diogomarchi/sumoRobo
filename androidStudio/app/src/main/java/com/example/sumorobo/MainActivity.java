package com.example.sumorobo;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.view.View.OnTouchListener;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {


    private Button bEsquerda, bDireita, bCima, bBaixo;
    private TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //instanciando os botoes e caixa de texto
        bEsquerda = findViewById(R.id.bEsquerdaID);
        bDireita = findViewById(R.id.bDireitaID);
        bCima = findViewById(R.id.bCimaID);
        bBaixo = findViewById(R.id.bBaixoID);
        titulo = findViewById(R.id.textView);



        // referencia ao banco e as variaveis
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference command = database.getReference(
                "command"
        );

        // Enquanto presssiona botao esquerdo
        bEsquerda.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    command.setValue(2);
                    return false;
                }else{
		    command.setValue(0);
                    return true;
                }
            }
        });


        // Enquanto presssiona botao direito
        bDireita.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    command.setValue(3);
                    return false;
                }else{
                    command.setValue(0);
                    return true;
                }
            }
        });

        // Enquanto presssiona botao pra cima
        bCima.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    command.setValue(1);
                    return false;
                }else{
                    command.setValue(0);
                    return true;
                }
            }
        });

        // Enquanto presssiona botao pra baixo
        bBaixo.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    command.setValue(-1);
                    return false;
                }else{
                    command.setValue(0);
                    return true;
                }
            }
        });
    }
}

