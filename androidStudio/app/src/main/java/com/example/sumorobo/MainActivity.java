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
        DatabaseReference dbrRigthOn = database.getReference(
                "rigth_on"
        );
        DatabaseReference dbrLeftOn = database.getReference(
                "left_on"
        );

        // Enquanto presssiona botao esquerdo
        bEsquerda.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    dbrLeftOn.setValue(-1);
                    dbrRigthOn.setValue(1);
                    return false;
                }else{
                    dbrLeftOn.setValue(0);
                    dbrRigthOn.setValue(0);
                    return true;
                }
            }
        });


        // Enquanto presssiona botao direito
        bDireita.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    dbrLeftOn.setValue(1);
                    dbrRigthOn.setValue(-1);
                    return false;
                }else{
                    dbrLeftOn.setValue(0);
                    dbrRigthOn.setValue(0);
                    return true;
                }
            }
        });

        // Enquanto presssiona botao pra cima
        bCima.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    dbrLeftOn.setValue(1);
                    dbrRigthOn.setValue(1);
                    return false;
                }else{
                    dbrLeftOn.setValue(0);
                    dbrRigthOn.setValue(0);
                    return true;
                }
            }
        });

        // Enquanto presssiona botao pra baixo
        bBaixo.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    dbrLeftOn.setValue(-1);
                    dbrRigthOn.setValue(-1);
                    return false;
                }else{
                    dbrLeftOn.setValue(0);
                    dbrRigthOn.setValue(0);
                    return true;
                }
            }
        });
    }
}

