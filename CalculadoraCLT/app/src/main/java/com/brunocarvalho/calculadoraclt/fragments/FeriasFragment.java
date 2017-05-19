package com.brunocarvalho.calculadoraclt.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.brunocarvalho.calculadoraclt.R;
import com.brunocarvalho.calculadoraclt.ResultActivity;
import com.brunocarvalho.calculadoraclt.negocio.service.Calculadora;
import com.brunocarvalho.calculadoraclt.negocio.service.impl.CalculadoraImpl;
import com.brunocarvalho.calculadoraclt.negocio.to.CalculadoraTO;
import com.brunocarvalho.calculadoraclt.util.ConstantsUtil;

/**
 * Created by carva on 13/05/2017.
 */

public class FeriasFragment extends Fragment {

    private Calculadora calc;

    private EditText editTextSalBruto;
    private EditText editTextHrsExtras;
    private EditText editTextNumDependentes;
    private EditText editTextDiasUsufruidos;
    private Switch switchAbono;
    private Switch switchAdiantamento;

    private Button btnCalcular;

    private InputMethodManager imm;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_ferias, container, false);

        findViews(rootView);

        createListeners();

        calc = new CalculadoraImpl();

        return rootView;
    }

    private void findViews(View view) {

        editTextSalBruto = (EditText) view.findViewById(R.id.edit_text_salario_bruto);
        editTextHrsExtras = (EditText) view.findViewById(R.id.edit_text_horas_extras);
        editTextNumDependentes = (EditText) view.findViewById(R.id.edit_text_dependentes);
        editTextDiasUsufruidos = (EditText) view.findViewById(R.id.edit_text_dias_usufruidos);
        switchAbono = (Switch) view.findViewById(R.id.switch_abono_pecuniario);
        switchAdiantamento = (Switch) view.findViewById(R.id.switch_adiantar_decimo_terceiro);

        btnCalcular = (Button) view.findViewById(R.id.btn_calcular_ferias);

        imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    private void createListeners() {
        // Button Calcular
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CalculadoraTO dados = obterValores();

                calc.calcularFerias(dados);

                Intent intent = new Intent(getActivity(), ResultActivity.class);
                intent.putExtra(ConstantsUtil.RESULTADO, dados);

                startActivity(intent);
            }
        });
    }

    private CalculadoraTO obterValores() {
        final CalculadoraTO dados = new CalculadoraTO();

        dados.setTituloResultado(ConstantsUtil.FERIAS);

        dados.setVrSalBruto(editTextSalBruto.getText().toString());
        dados.setVrHrsExtras(editTextHrsExtras.getText().toString());
        dados.setNumDependentes(editTextNumDependentes.getText().toString());
        dados.setVrDiasFerias(editTextDiasUsufruidos.getText().toString());
        dados.setIcAbonoPecuniario(switchAbono.isChecked());
        dados.setIcAdiantamento(switchAdiantamento.isChecked());

        return dados;
    }
}
