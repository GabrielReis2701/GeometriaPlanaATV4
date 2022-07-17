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
 * Use the {@link FragmentLosango#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentLosango extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View construtor;
    private EditText et_DMaior, et_DMenor;
    private Button bt_calcular;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentLosango() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentLosango.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentLosango newInstance(String param1, String param2) {
        FragmentLosango fragment = new FragmentLosango();
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
        construtor =  inflater.inflate(R.layout.fragment_losango, container, false);

        et_DMaior = construtor.findViewById(R.id.et_DMaior);
        et_DMenor = construtor.findViewById(R.id.et_DMenor);
        bt_calcular = construtor.findViewById(R.id.bt_calcularLosango);

        bt_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double diagonalMaior =0, diagonalMenor=0,area=0;
                boolean erro =false;
                try {
                    diagonalMaior = Double.parseDouble(et_DMaior.getText().toString());
                    diagonalMenor = Double.parseDouble(et_DMenor.getText().toString());
                }catch (Exception e){
                    diagonalMaior=0;
                    diagonalMenor=0;
                    erro = true;
                }
                if((diagonalMaior == 0 || diagonalMenor == 0) && erro == true){
                    AlertDialog.Builder janela = new AlertDialog.Builder(getActivity());
                    janela.setTitle("Calculo do Losango");
                    janela.setMessage("ERRO! Por favor preencha todos os campos");
                    janela.setNeutralButton("OK",null);
                    janela.show();
                }else{
                    area = (diagonalMaior*diagonalMenor)/2;
                    AlertDialog.Builder janela = new AlertDialog.Builder(getActivity());
                    janela.setTitle("Calculo do Losango");
                    janela.setMessage("A Área do Losango é: "+ area);
                    janela.setNeutralButton("OK",null);
                    janela.show();

                }
            }
        });

        return construtor;
    }
}