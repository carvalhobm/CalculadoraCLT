package com.brunocarvalho.calculadoraclt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.brunocarvalho.calculadoraclt.enuns.AvisoPrevioEnum;
import com.brunocarvalho.calculadoraclt.enuns.MotivoEnum;
import com.brunocarvalho.calculadoraclt.negocio.to.CalculadoraTO;
import com.brunocarvalho.calculadoraclt.util.ConstantsUtil;
import com.brunocarvalho.calculadoraclt.util.StringUtil;

public class ResultActivity extends AppCompatActivity {

    //Campos Rescisao
    private TextView textViewDtContratacao;
    private TextView textViewDtDesligamento;
    private TextView textViewMotivo;
    private TextView textViewAviso;
    private TextView textViewFeriasVencidas;
    private TextView textViewVrSaldoFgts;

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

        Intent intent = this.getIntent();
        final CalculadoraTO dados = (CalculadoraTO) intent.getSerializableExtra(ConstantsUtil.RESULTADO);

        this.setTitle(dados.getTituloResultado());

        switch (dados.getTituloResultado()) {
            case ConstantsUtil.SAL_LIQUIDO:
                this.setContentView(R.layout.activity_result_sal_liquido);
                this.findViewsSalLiquido();
                this.atribuirValoresEmTelaSalLiquido(dados);
                break;
            case ConstantsUtil.FERIAS:
                this.setContentView(R.layout.activity_result_ferias);
                this.findViewsFerias();
                this.atribuirValoresEmTelaFerias(dados);
                break;
            default:
                this.setContentView(R.layout.activity_result_rescisao);
                this.findViewsRescisao();
                this.atribuirValoresEmTelaRescisao(dados);
                break;
        }

        Toolbar toolbar = (Toolbar) this.findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);
        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void findViewsRescisao() {

        this.textViewVrSalBruto = (TextView) this.findViewById(R.id.text_view_sal_bruto_val);
        this.textViewNumDependentes = (TextView) this.findViewById(R.id.text_view_dependentes_val);
        this.textViewTituloResultado = (TextView) this.findViewById(R.id.text_view_titulo_resultado);

        this.textViewDtContratacao = (TextView) this.findViewById(R.id.text_view_dt_contratacao_val);
        this.textViewDtDesligamento = (TextView) this.findViewById(R.id.text_view_dt_demissao_val);

        this.textViewMotivo = (TextView) this.findViewById(R.id.text_view_motivo_val);
        this.textViewAviso = (TextView) this.findViewById(R.id.text_view_aviso_val);

        this.textViewFeriasVencidas = (TextView) this.findViewById(R.id.text_view_ferias_vencidas_val);
        this.textViewVrSaldoFgts = (TextView) this.findViewById(R.id.text_view_saldo_fgts_val);
    }

    private void findViewsFerias() {

        this.textViewHrExtra = (TextView) this.findViewById(R.id.text_view_hr_extra_val);
        this.textViewDiasUsufruidos = (TextView) this.findViewById(R.id.text_view_dias_usufruidos_val);
        this.textViewAbonoPecuniario = (TextView) this.findViewById(R.id.text_view_abono_pecuniario_val);
        this.textViewVrFerias = (TextView) this.findViewById(R.id.text_view_ferias_val);
        this.textViewVrFeriasTerco = (TextView) this.findViewById(R.id.text_view_ferias_terco_val);
        this.textViewVrAbono = (TextView) this.findViewById(R.id.text_view_pro_abono_pecuniario_val);
        this.textViewVrAbonoAdicional = (TextView) this.findViewById(R.id.text_view_pro_abono_pecuniario_adicional_val);

        this.findViewsComuns();
    }

    private void findViewsSalLiquido() {

        this.textViewProventoSalBruto = (TextView) this.findViewById(R.id.text_view_provento_sal_bruto_val);
        this.textViewVrPensao = (TextView) this.findViewById(R.id.text_view_pensao_val);
        this.textViewVrPlanoSaude = (TextView) this.findViewById(R.id.text_view_plano_saude_val);
        this.textViewVrOutrosDescontos = (TextView) this.findViewById(R.id.text_view_outros_descontos_val);
        this.textViewDescOutrosDescontos = (TextView) this.findViewById(R.id.text_view_desc_outros_descontos_val);

        this.findViewsComuns();
    }

    private void findViewsComuns() {
        this.textViewVrSalBruto = (TextView) this.findViewById(R.id.text_view_sal_bruto_val);
        this.textViewNumDependentes = (TextView) this.findViewById(R.id.text_view_dependentes_val);

        this.textViewTituloResultado = (TextView) this.findViewById(R.id.text_view_titulo_resultado);

        this.textViewInssVal = (TextView) this.findViewById(R.id.text_view_inss_val);
        this.textViewIrrfVal = (TextView) this.findViewById(R.id.text_view_irrf_val);
    }

    private void atribuirValoresEmTelaRescisao(final CalculadoraTO dados) {

        this.textViewVrSalBruto.setText(StringUtil.formatNumberToString(dados.getVrSalBruto()));
        this.textViewNumDependentes.setText(StringUtil.formatNumberToString(dados.getNumDependentes()));

        if (dados.getDtContratacao() != null) {

            this.textViewDtContratacao.setText(StringUtil.formatDateToString(dados.getDtContratacao()));
        }
        if (dados.getDtDesligamento() != null) {
            this.textViewDtDesligamento.setText(StringUtil.formatDateToString(dados.getDtDesligamento()));
        }

        this.textViewMotivo.setText(MotivoEnum.getDeMotivoByCodigo(dados.getIcMotivo()));
        this.textViewAviso.setText(AvisoPrevioEnum.getDeAvisoPrevisoByCodigo(dados.getIcAviso()));

        this.textViewFeriasVencidas.setText(StringUtil.formatNumberToString(dados.getVrDiasFeriasVencidas()));
        this.textViewVrSaldoFgts.setText(StringUtil.formatNumberToString(dados.getVrSaldoFgts()));

        this.textViewTituloResultado.setText(this.textViewTituloResultado.getText().toString().concat(" - R$ ").concat(dados.getVrResultado().toString()));
    }

    private void atribuirValoresEmTelaFerias(final CalculadoraTO dados) {

        this.textViewHrExtra.setText(StringUtil.formatNumberToString(dados.getVrHrsExtras()));
        this.textViewDiasUsufruidos.setText(StringUtil.formatNumberToString(dados.getVrDiasFerias()));

        if (dados.getIcAbonoPecuniario()) {
            this.textViewAbonoPecuniario.setText(R.string.label_sim);
        } else {
            this.textViewAbonoPecuniario.setText(R.string.label_nao);
        }

        this.textViewVrFerias.setText(StringUtil.formatNumberToString(dados.getVrFerias()));
        this.textViewVrFeriasTerco.setText(StringUtil.formatNumberToString(dados.getVrAdicionalFerias()));
        this.textViewVrAbono.setText(StringUtil.formatNumberToString(dados.getVrAbono()));
        this.textViewVrAbonoAdicional.setText(StringUtil.formatNumberToString(dados.getVrAdicionalAbono()));

        this.atribuirValoresComunsEmTela(dados);
    }

    private void atribuirValoresEmTelaSalLiquido(final CalculadoraTO dados) {

        this.textViewVrPensao.setText(StringUtil.formatNumberToString(dados.getVrPensaoAlimenticia()));
        this.textViewVrPlanoSaude.setText(StringUtil.formatNumberToString(dados.getVrPlanoSaude()));
        this.textViewVrOutrosDescontos.setText(StringUtil.formatNumberToString(dados.getVrOutrosDescontos()));
        this.textViewDescOutrosDescontos.setText(StringUtil.formatNumberToString(dados.getVrTotalOutrosDescontos()));
        this.textViewProventoSalBruto.setText(StringUtil.formatNumberToString(dados.getVrSalBruto()));

        this.atribuirValoresComunsEmTela(dados);
    }

    private void atribuirValoresComunsEmTela(CalculadoraTO dados) {
        this.textViewVrSalBruto.setText(StringUtil.formatNumberToString(dados.getVrSalBruto()));
        this.textViewNumDependentes.setText(StringUtil.formatNumberToString(dados.getNumDependentes()));

        this.textViewTituloResultado.setText(this.textViewTituloResultado.getText().toString().concat(" - R$ ").concat(StringUtil.formatNumberToString(dados.getVrResultado())));

        this.textViewInssVal.setText(StringUtil.formatNumberToString(dados.getVrInss()));
        this.textViewIrrfVal.setText(StringUtil.formatNumberToString(dados.getVrIrrf()));
    }
}
