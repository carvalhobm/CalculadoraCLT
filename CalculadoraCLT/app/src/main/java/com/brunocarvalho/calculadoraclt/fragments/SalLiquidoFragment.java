package com.brunocarvalho.calculadoraclt.fragments;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.brunocarvalho.calculadoraclt.R;
import com.brunocarvalho.calculadoraclt.ResultActivity;
import com.brunocarvalho.calculadoraclt.negocio.calculadora.Calculadora;
import com.brunocarvalho.calculadoraclt.negocio.to.CalculadoraTO;
import com.brunocarvalho.calculadoraclt.util.ConstantsUtil;

/**
 * Created by carva on 13/05/2017.
 */

public class SalLiquidoFragment extends Fragment {

    private Calculadora calc;

    private Button btnCalcular;

    private InputMethodManager imm;

    private EditText editTextVrSalBruto;
    private EditText editTextNumDependentes;
    private EditText editTextOutrosDescontos;

    public SalLiquidoFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_sal_liquido, container, false);

        findViews(rootView);

        createListeners();

        calc = new Calculadora();

        return rootView;
    }

    private void findViews(View view) {

        editTextVrSalBruto = (EditText) view.findViewById(R.id.input_salario_bruto);
        editTextNumDependentes = (EditText) view.findViewById(R.id.input_dependentes);
        editTextOutrosDescontos = (EditText) view.findViewById(R.id.input_descontos);

        btnCalcular = (Button) view.findViewById(R.id.btn_calcular_sal_liquido);

        imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    private void createListeners() {
        // Button Calcular
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final CalculadoraTO dados = obterValores();

                calc.calcularSalarioLiquido(dados);

                final Intent intent = new Intent(getActivity(), ResultActivity.class);
                intent.putExtra(ConstantsUtil.RESULTADO, dados);

                startActivity(intent);
            }
        });
    }

    private CalculadoraTO obterValores(){
        final CalculadoraTO dados = new CalculadoraTO();

        if(!editTextVrSalBruto.getText().toString().equals("")){
            dados.setVrSalBruto(Double.valueOf(editTextVrSalBruto.getText().toString()));
        }
        if(!editTextNumDependentes.getText().toString().equals("")){
            dados.setNumDependentes(Integer.valueOf(editTextNumDependentes.getText().toString()));
        }
        if(!editTextOutrosDescontos.getText().toString().equals("")){
            dados.setVrOutrosDescontos(Double.valueOf(editTextOutrosDescontos.getText().toString()));
        }

        return dados;
    }

}
