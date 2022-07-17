package com.example.geometriaplanaatv4;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentTriangulo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTriangulo extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View construtor;
    private EditText et_valorA,et_valorB;
    private Button bt_calcular;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentTriangulo() {

        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTriangulo.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentTriangulo newInstance(String param1, String param2) {
        FragmentTriangulo fragment = new FragmentTriangulo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        construtor = inflater.inflate(R.layout.fragment_triangulo, container, false);
        et_valorA = construtor.findViewById(R.id.et_valorA);
        et_valorB = construtor.findViewById(R.id.et_valorB);
        bt_calcular = construtor.findViewById(R.id.bt_calcular);

        bt_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double area,base,altura;
                boolean erro = false;
                try{
                    base = Double.parseDouble(et_valorB.getText().toString());
                    altura = Double.parseDouble(et_valorA.getText().toString());
                }catch (Exception e){
                    base =0;
                    altura=0;
                    erro = true;
                }
                if ((base==0 || altura ==0) && erro==true){
                    AlertDialog.Builder janela = new AlertDialog.Builder(getActivity());
                    janela.setTitle("Calculo do Triangulo");
                    janela.setMessage("Erro! Por favor preencha todos os campos");
                    janela.setNeutralButton("OK",null);
                    janela.show();
                }else{
                    area = (base*altura)/2;
                    AlertDialog.Builder janela = new AlertDialog.Builder(getActivity());
                    janela.setTitle("Calculo do Triangulo");
                    janela.setMessage("O Valor da Area é: "+ area);
                    janela.setNeutralButton("OK",null);
                    janela.show();
                }

            }
        });


        return construtor;

    }
}
