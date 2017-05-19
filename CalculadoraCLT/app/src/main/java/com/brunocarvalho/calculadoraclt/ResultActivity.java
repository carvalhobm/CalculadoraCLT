package com.brunocarvalho.calculadoraclt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.brunocarvalho.calculadoraclt.negocio.to.CalculadoraTO;
import com.brunocarvalho.calculadoraclt.util.ConstantsUtil;

public class ResultActivity extends AppCompatActivity {

    private TextView textViewVrSalBruto;
    private TextView textViewNumDependentes;

    private TextView textViewTituloResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViews();

        Intent intent = getIntent();
        final CalculadoraTO dados = (CalculadoraTO) intent.getSerializableExtra(ConstantsUtil.RESULTADO);

        atribuirValoresEmTela(dados);
    }

    private void findViews() {
        textViewVrSalBruto = (TextView) findViewById(R.id.text_view_sal_bruto_val);
        textViewNumDependentes = (TextView) findViewById(R.id.text_view_dependentes_val);
        textViewTituloResultado = (TextView) findViewById(R.id.text_view_titulo_resultado);
    }

    private void atribuirValoresEmTela(final CalculadoraTO dados){

        textViewVrSalBruto.setText(dados.getVrSalBruto().toString());
        textViewNumDependentes.setText(dados.getNumDependentes().toString());

        textViewTituloResultado.setText(textViewTituloResultado.getText().toString().concat(" - R$ ").concat(dados.getVrResultado().toString()));
    }

}
