package com.example.geometriaplanaatv4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class fragmentGeo extends AppCompatActivity {

    private Button bt_traingulo,bt_trapezio,bt_losangulo,bt_calcular;
    private EditText et_valorB,et_valorA;
    private FragmentTriangulo fragmentTriangulo;
    private FragmentTrapezio fragmentTrapezio;
    private FragmentLosango fragmentLosango;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_geo);

        getSupportActionBar().setElevation(0);
        bt_traingulo = findViewById(R.id.bt_triangulo);
        bt_trapezio = findViewById(R.id.bt_trapezio);
        bt_losangulo = findViewById(R.id.bt_losango);
        bt_calcular = findViewById(R.id.bt_calcular);


        fragmentTriangulo = new FragmentTriangulo();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame_conteudo,fragmentTriangulo);
        fragmentTransaction.commit();

        bt_traingulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTriangulo = new FragmentTriangulo();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_conteudo,fragmentTriangulo);
                fragmentTransaction.commit();
            }
        });
        bt_trapezio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTrapezio = new FragmentTrapezio();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_conteudo,fragmentTrapezio);
                fragmentTransaction.commit();
            }
        });
        bt_losangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentLosango = new FragmentLosango();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_conteudo,fragmentLosango);
                fragmentTransaction.commit();
            }
        });



    }
}