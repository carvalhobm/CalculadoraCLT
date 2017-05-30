package com.brunocarvalho.calculadoraclt.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.brunocarvalho.calculadoraclt.R;
import com.brunocarvalho.calculadoraclt.ResultActivity;
import com.brunocarvalho.calculadoraclt.negocio.service.Calculadora;
import com.brunocarvalho.calculadoraclt.negocio.service.impl.CalculadoraImpl;
import com.brunocarvalho.calculadoraclt.negocio.to.CalculadoraTO;
import com.brunocarvalho.calculadoraclt.util.ConstantsUtil;

import java.math.BigDecimal;

public class SalLiquidoFragment extends Fragment {

    private Calculadora calc;

    private Button btnCalcular;

    private EditText editTextVrSalBruto;
    private EditText editTextNumDependentes;
    private EditText editTextPensao;
    private EditText editTextPlanoSaude;
    private EditText editTextOutrosDescontos;

    private TextInputLayout textInputSalBruto;

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

        this.findViews(rootView);

        this.createListeners();

        this.calc = new CalculadoraImpl();

        return rootView;
    }

    private void findViews(View view) {

        this.editTextVrSalBruto = (EditText) view.findViewById(R.id.edit_text_salario_bruto);
        this.editTextNumDependentes = (EditText) view.findViewById(R.id.edit_text_dependentes);
        this.editTextPensao = (EditText) view.findViewById(R.id.edit_text_pensao);
        this.editTextPlanoSaude = (EditText) view.findViewById(R.id.edit_text_plano_saude);
        this.editTextOutrosDescontos = (EditText) view.findViewById(R.id.edit_text_descontos);

        this.textInputSalBruto = (TextInputLayout) view.findViewById(R.id.input_layout_salario_bruto);

        this.btnCalcular = (Button) view.findViewById(R.id.btn_calcular_sal_liquido);
    }

    private void createListeners() {

        // Button Calcular
        this.btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final CalculadoraTO dados = SalLiquidoFragment.this.obterValores();

                if (SalLiquidoFragment.this.validInput(dados)) {
                    SalLiquidoFragment.this.calc.calcularSalarioLiquido(dados);

                    final Intent intent = new Intent(SalLiquidoFragment.this.getActivity(), ResultActivity.class);
                    intent.putExtra(ConstantsUtil.RESULTADO, dados);

                    SalLiquidoFragment.this.startActivity(intent);
                }
            }
        });
    }

    public Boolean validInput(final CalculadoraTO dados) {
        Boolean isInputValid = Boolean.TRUE;

        if (dados.getVrSalBruto() == null || dados.getVrSalBruto().compareTo(BigDecimal.ZERO) <= 0) {
            this.textInputSalBruto.setError(this.getString(R.string.sal_bruto_invalido));
            isInputValid = Boolean.FALSE;
        }

        return isInputValid;
    }

    private CalculadoraTO obterValores() {
        final CalculadoraTO dados = new CalculadoraTO();

        dados.setTituloResultado(ConstantsUtil.SAL_LIQUIDO);

        dados.setVrSalBruto(this.editTextVrSalBruto.getText().toString());
        dados.setNumDependentes(this.editTextNumDependentes.getText().toString());
        dados.setVrPensaoAlimenticia(this.editTextPensao.getText().toString());
        dados.setVrPlanoSaude(this.editTextPlanoSaude.getText().toString());
        dados.setVrOutrosDescontos(this.editTextOutrosDescontos.getText().toString());

        return dados;
    }

}
