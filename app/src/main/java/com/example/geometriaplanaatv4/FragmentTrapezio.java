package com.example.geometriaplanaatv4;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentTrapezio#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTrapezio extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View construtor;
    private EditText et_valorBaseMaior,et_valorBaseMenor,et_valorA;
    private Button bt_calcular;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentTrapezio() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentTrapezio.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentTrapezio newInstance(String param1, String param2) {
        FragmentTrapezio fragment = new FragmentTrapezio();
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
        construtor =  inflater.inflate(R.layout.fragment_trapezio, container, false);
        et_valorA = construtor.findViewById(R.id.et_valorAlturaTrape);
        et_valorBaseMaior = construtor.findViewById(R.id.et_valorBMaior);
        et_valorBaseMenor = construtor.findViewById(R.id.et_valorBMenor);
        bt_calcular = construtor.findViewById(R.id.bt_calcularTrape);

        bt_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double area,altura=0,baseMenor=0,baseMaior=0;
                boolean erro=false;
                try{
                    baseMaior = Double.parseDouble(et_valorBaseMaior.getText().toString());
                    baseMenor = Double.parseDouble(et_valorBaseMenor.getText().toString());
                    altura = Double.parseDouble(et_valorA.getText().toString());
                }catch (Exception e){
                    baseMaior =0;
                    altura=0;
                    baseMenor=0;
                    erro = true;
                }

                if((baseMaior == 0 || baseMenor == 0 || altura ==0)&& erro == true){
                    AlertDialog.Builder janela2 = new AlertDialog.Builder(getActivity());
                    janela2.setTitle("Calculo do Trapézio");
                    janela2.setMessage("ERRO! Por favor preencha todos os campos antes de continuar");
                    janela2.setNeutralButton("OK",null);
                    janela2.show();
                }else{
                    area = ((baseMaior+baseMenor)*altura)/2;
                    AlertDialog.Builder janela = new AlertDialog.Builder(getActivity());
                    janela.setTitle("Calculo do Trapézio");
                    janela.setMessage("A Área do Trapézio é: "+area);
                    janela.setNeutralButton("OK",null);
                    janela.show();
                }

            }
        });

        return construtor;
    }
}