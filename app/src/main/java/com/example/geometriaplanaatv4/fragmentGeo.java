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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_geo);

        getSupportActionBar().setElevation(0);
        bt_traingulo = findViewById(R.id.bt_triangulo);
        bt_trapezio = findViewById(R.id.bt_trapezio);
        bt_losangulo = findViewById(R.id.bt_losango);
        bt_calcular = findViewById(R.id.bt_calcular);
        et_valorA = findViewById(R.id.et_valorA);
        et_valorB = findViewById(R.id.et_valorB);

        fragmentTriangulo = new FragmentTriangulo();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame_conteudo,fragmentTriangulo);
        fragmentTransaction.commit();

        bt_traingulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTriangulo = new FragmentTriangulo();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.frame_conteudo,fragmentTriangulo);
                fragmentTransaction.commit();
            }
        });
        bt_trapezio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTrapezio = new FragmentTrapezio();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.frame_conteudo,fragmentTrapezio);
                fragmentTransaction.commit();
            }
        });
        bt_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double valorAl=0,valorB=0,are=0;
                valorAl = Double.parseDouble(et_valorA.getText().toString());
                valorB = Double.parseDouble(et_valorB.getText().toString());
                are = (valorB*valorAl)/2;

                if(et_valorA==null || et_valorB ==null){
                    Toast.makeText(fragmentGeo.this, "Preencha todos os campos por favor", Toast.LENGTH_LONG).show();
                }else{
                    AlertDialog.Builder janela = new AlertDialog.Builder(fragmentGeo.this);
                    janela.setTitle("GEOMETRIA PLANA");
                    janela.setMessage(String.format("A área do triângulo é: %.2f",are));
                    janela.show();
                }



            }
        });


    }
}