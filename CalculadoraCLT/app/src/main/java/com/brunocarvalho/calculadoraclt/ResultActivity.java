package com.brunocarvalho.calculadoraclt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.brunocarvalho.calculadoraclt.negocio.to.CalculadoraTO;
import com.brunocarvalho.calculadoraclt.util.ConstantsUtil;

public class ResultActivity extends AppCompatActivity {

    //Campos Ferias
    private TextView textViewHrExtra;
    private TextView textViewDiasUsufruidos;
    private TextView textViewAbonoPecuniario;
    private TextView textViewVrFerias;
    private TextView textViewVrFeriasTerco;
    private TextView textViewVrAbono;
    private TextView textViewVrAbonoAdicional;

    //Campos Sal. Liquido
    private TextView textViewVrPensao;
    private TextView textViewVrPlanoSaude;
    private TextView textViewVrOutrosDescontos;
    private TextView textViewProventoSalBruto;
    private TextView textViewInssVal;
    private TextView textViewIrrfVal;
    private TextView textViewDescOutrosDescontos;


    //Campo Comum
    private TextView textViewVrSalBruto;
    private TextView textViewNumDependentes;
    private TextView textViewTituloResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        final CalculadoraTO dados = (CalculadoraTO) intent.getSerializableExtra(ConstantsUtil.RESULTADO);

        this.setTitle(dados.getTituloResultado());

        switch (dados.getTituloResultado()) {
            case ConstantsUtil.SAL_LIQUIDO:
                setContentView(R.layout.activity_result_sal_liquido);
                findViewsSalLiquido();
                atribuirValoresEmTelaSalLiquido(dados);
                break;
            case ConstantsUtil.FERIAS:
                setContentView(R.layout.activity_result_ferias);
                findViewsFerias();
                atribuirValoresEmTelaFerias(dados);
                break;
            default:
                setContentView(R.layout.activity_result_sal_liquido);
                findViewsRescisao();
                atribuirValoresEmTelaRescisao(dados);
                break;
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void findViewsRescisao() {

        textViewVrSalBruto = (TextView) findViewById(R.id.text_view_sal_bruto_val);
        textViewNumDependentes = (TextView) findViewById(R.id.text_view_dependentes_val);
        textViewTituloResultado = (TextView) findViewById(R.id.text_view_titulo_resultado);
    }

    private void findViewsFerias() {

        textViewHrExtra = (TextView) findViewById(R.id.text_view_hr_extra_val);
        textViewDiasUsufruidos = (TextView) findViewById(R.id.text_view_dias_usufruidos_val);
        textViewAbonoPecuniario = (TextView) findViewById(R.id.text_view_abono_pecuniario_val);
        textViewVrFerias = (TextView) findViewById(R.id.text_view_ferias_val);
        textViewVrFeriasTerco = (TextView) findViewById(R.id.text_view_ferias_terco_val);
        textViewVrAbono = (TextView) findViewById(R.id.text_view_pro_abono_pecuniario_val);
        textViewVrAbonoAdicional = (TextView) findViewById(R.id.text_view_pro_abono_pecuniario_adicional_val);

        findViewsComuns();
    }

    private void findViewsSalLiquido() {

        textViewProventoSalBruto = (TextView) findViewById(R.id.text_view_provento_sal_bruto_val);
        textViewVrPensao = (TextView) findViewById(R.id.text_view_pensao_val);
        textViewVrPlanoSaude = (TextView) findViewById(R.id.text_view_plano_saude_val);
        textViewVrOutrosDescontos = (TextView) findViewById(R.id.text_view_outros_descontos_val);
        textViewDescOutrosDescontos = (TextView) findViewById(R.id.text_view_desc_outros_descontos_val);

        findViewsComuns();
    }

    private void findViewsComuns() {
        textViewVrSalBruto = (TextView) findViewById(R.id.text_view_sal_bruto_val);
        textViewNumDependentes = (TextView) findViewById(R.id.text_view_dependentes_val);

        textViewTituloResultado = (TextView) findViewById(R.id.text_view_titulo_resultado);

        textViewInssVal = (TextView) findViewById(R.id.text_view_inss_val);
        textViewIrrfVal = (TextView) findViewById(R.id.text_view_irrf_val);
    }

    private void atribuirValoresEmTelaRescisao(final CalculadoraTO dados) {

        textViewVrSalBruto.setText(dados.getVrSalBruto().toString());
        textViewNumDependentes.setText(dados.getNumDependentes().toString());

        textViewTituloResultado.setText(textViewTituloResultado.getText().toString().concat(" - R$ ").concat(dados.getVrResultado().toString()));
    }

    private void atribuirValoresEmTelaFerias(final CalculadoraTO dados) {

        textViewHrExtra.setText(dados.getVrHrsExtras().toString());
        textViewDiasUsufruidos.setText(dados.getVrDiasFerias().toString());

        if (dados.getIcAbonoPecuniario()) {
            textViewAbonoPecuniario.setText(R.string.label_sim);
        } else {
            textViewAbonoPecuniario.setText(R.string.label_nao);
        }

        textViewVrFerias.setText(dados.getVrFerias().toString());
        textViewVrFeriasTerco.setText(dados.getVrAdicionalFerias().toString());
        textViewVrAbono.setText(dados.getVrAbono().toString());
        textViewVrAbonoAdicional.setText(dados.getVrAdicionalAbono().toString());

        atribuirValoresComunsEmTela(dados);
    }

    private void atribuirValoresEmTelaSalLiquido(final CalculadoraTO dados) {

        textViewVrPensao.setText(dados.getVrPensaoAlimenticia().toString());
        textViewVrPlanoSaude.setText(dados.getVrPlanoSaude().toString());
        textViewVrOutrosDescontos.setText(dados.getVrOutrosDescontos().toString());
        textViewDescOutrosDescontos.setText(dados.getVrTotalOutrosDescontos().toString());
        textViewProventoSalBruto.setText(dados.getVrSalBruto().toString());

        atribuirValoresComunsEmTela(dados);
    }

    private void atribuirValoresComunsEmTela(CalculadoraTO dados) {
        textViewVrSalBruto.setText(dados.getVrSalBruto().toString());
        textViewNumDependentes.setText(dados.getNumDependentes().toString());

        textViewTituloResultado.setText(textViewTituloResultado.getText().toString().concat(" - R$ ").concat(dados.getVrResultado().toString()));

        textViewInssVal.setText(dados.getVrInss().toString());
        textViewIrrfVal.setText(dados.getVrIrrf().toString());
    }

}
