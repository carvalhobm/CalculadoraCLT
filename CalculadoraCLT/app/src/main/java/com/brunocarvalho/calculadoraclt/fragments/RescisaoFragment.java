package com.brunocarvalho.calculadoraclt.fragments;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.brunocarvalho.calculadoraclt.R;
import com.brunocarvalho.calculadoraclt.ResultActivity;
import com.brunocarvalho.calculadoraclt.enuns.AvisoPrevioEnum;
import com.brunocarvalho.calculadoraclt.enuns.MotivoEnum;
import com.brunocarvalho.calculadoraclt.negocio.service.Calculadora;
import com.brunocarvalho.calculadoraclt.negocio.service.impl.CalculadoraImpl;
import com.brunocarvalho.calculadoraclt.negocio.to.CalculadoraTO;
import com.brunocarvalho.calculadoraclt.util.ConstantsUtil;
import com.brunocarvalho.calculadoraclt.util.StringUtil;

import java.util.Calendar;

public class RescisaoFragment extends Fragment {

    private Calculadora calc;

    private EditText editTextSalBruto;
    private EditText editTextDtContratacao;
    private EditText editTextDtDemissao;
    private EditText editTextMotivo;
    private EditText editTextAviso;
    private EditText editTextDependentes;
    private EditText editTextVrSaldoFgts;

    private DatePickerDialog datePickerContratacao;
    private DatePickerDialog datePickerDemissao;

    private Spinner spinnerMotivo;
    private Spinner spinnerAviso;

    private Button btnCalcular;

    private View rootView;
    private InputMethodManager imm;

    public RescisaoFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {

        this.rootView = inflater.inflate(R.layout.fragment_rescisao, container, false);

        this.findViews(this.rootView);

        this.createListeners();

        this.setDateTimeField();

        ArrayAdapter<MotivoEnum> adapterMotivo = new ArrayAdapter<>(this.getActivity(),
                android.R.layout.simple_dropdown_item_1line, MotivoEnum.values());
        this.spinnerMotivo.setAdapter(adapterMotivo);

        ArrayAdapter<AvisoPrevioEnum> adapterAviso = new ArrayAdapter<>(this.getActivity(),
                android.R.layout.simple_dropdown_item_1line, AvisoPrevioEnum.values());
        this.spinnerAviso.setAdapter(adapterAviso);

        this.calc = new CalculadoraImpl();

        return this.rootView;
    }

    private void findViews(View view) {

        this.editTextSalBruto = (EditText) view.findViewById(R.id.edit_text_salario_bruto);

        this.editTextDtContratacao = (EditText) view.findViewById(R.id.edit_text_dt_contratacao);
        this.editTextDtContratacao.setInputType(InputType.TYPE_NULL);

        this.editTextDtDemissao = (EditText) view.findViewById(R.id.edit_text_dt_demissao);
        this.editTextDtDemissao.setInputType(InputType.TYPE_NULL);

        this.editTextMotivo = (EditText) view.findViewById(R.id.edit_text_motivo);
        this.editTextMotivo.setInputType(InputType.TYPE_NULL);

        this.editTextAviso = (EditText) view.findViewById(R.id.edit_text_aviso);
        this.editTextAviso.setInputType(InputType.TYPE_NULL);

        this.editTextDependentes = (EditText) view.findViewById(R.id.edit_text_dependentes);
        this.editTextVrSaldoFgts = (EditText) view.findViewById(R.id.edit_text_saldo_fgts);

        this.spinnerMotivo = (Spinner) view.findViewById(R.id.spinner_motivo);
        this.spinnerAviso = (Spinner) view.findViewById(R.id.spinner_aviso);

        this.btnCalcular = (Button) view.findViewById(R.id.btn_calcular_rescisao);

        this.imm = (InputMethodManager) this.getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    private void setDateTimeField() {
        Calendar newCalendar = Calendar.getInstance();
        this.datePickerContratacao = new DatePickerDialog(this.getActivity(), new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                RescisaoFragment.this.editTextDtContratacao.setText(StringUtil.formatDateToString(newDate.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        this.datePickerDemissao = new DatePickerDialog(this.getActivity(), new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                RescisaoFragment.this.editTextDtDemissao.setText(StringUtil.formatDateToString(newDate.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

    }

    private void createListeners() {
        // EditText Contratação listener
        this.editTextDtContratacao.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    RescisaoFragment.this.imm.hideSoftInputFromWindow(RescisaoFragment.this.rootView.getWindowToken(), 0);
                    RescisaoFragment.this.datePickerContratacao.show();
                }
            }
        });

        this.editTextDtContratacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RescisaoFragment.this.imm.hideSoftInputFromWindow(RescisaoFragment.this.rootView.getWindowToken(), 0);
                RescisaoFragment.this.datePickerContratacao.show();
            }
        });

        // EditText Demissão listener
        this.editTextDtDemissao.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    RescisaoFragment.this.imm.hideSoftInputFromWindow(RescisaoFragment.this.rootView.getWindowToken(), 0);
                    RescisaoFragment.this.datePickerDemissao.show();
                }
            }
        });

        this.editTextDtDemissao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RescisaoFragment.this.imm.hideSoftInputFromWindow(RescisaoFragment.this.rootView.getWindowToken(), 0);
                RescisaoFragment.this.datePickerDemissao.show();
            }
        });

        // EditText Motivo listener
        this.editTextMotivo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    RescisaoFragment.this.imm.hideSoftInputFromWindow(RescisaoFragment.this.rootView.getWindowToken(), 0);
                    RescisaoFragment.this.spinnerMotivo.performClick();
                }
            }
        });

        this.editTextMotivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RescisaoFragment.this.imm.hideSoftInputFromWindow(RescisaoFragment.this.rootView.getWindowToken(), 0);
                RescisaoFragment.this.spinnerMotivo.performClick();
            }
        });

        // EditText Aviso listener
        this.editTextAviso.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    RescisaoFragment.this.imm.hideSoftInputFromWindow(RescisaoFragment.this.rootView.getWindowToken(), 0);
                    RescisaoFragment.this.spinnerAviso.performClick();
                }
            }
        });

        this.editTextAviso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RescisaoFragment.this.imm.hideSoftInputFromWindow(RescisaoFragment.this.rootView.getWindowToken(), 0);
                RescisaoFragment.this.spinnerAviso.performClick();
            }
        });

        // Spinner's
        this.spinnerMotivo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                RescisaoFragment.this.editTextMotivo.setText(RescisaoFragment.this.spinnerMotivo.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                RescisaoFragment.this.editTextMotivo.setText("");
            }
        });

        this.spinnerAviso.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                RescisaoFragment.this.editTextAviso.setText(RescisaoFragment.this.spinnerAviso.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                RescisaoFragment.this.editTextAviso.setText("");
            }
        });

        // Button Calcular
        this.btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final CalculadoraTO dados = RescisaoFragment.this.obterValores();

                RescisaoFragment.this.calc.calcularRescisao(dados);

                Intent intent = new Intent(RescisaoFragment.this.getActivity(), ResultActivity.class);
                intent.putExtra(ConstantsUtil.RESULTADO, dados);

                RescisaoFragment.this.startActivity(intent);
            }
        });
    }

    private CalculadoraTO obterValores() {
        final CalculadoraTO dados = new CalculadoraTO();

        dados.setTituloResultado(ConstantsUtil.RESCISAO);

        dados.setVrSalBruto(this.editTextSalBruto.getText().toString());

        dados.setIcMotivo(((MotivoEnum) this.spinnerMotivo.getSelectedItem()).getCoMotivo());
        dados.setIcAviso(((AvisoPrevioEnum) this.spinnerAviso.getSelectedItem()).getCoAvisoPrevio());

        dados.setNumDependentes(this.editTextDependentes.getText().toString());
        dados.setVrSaldoFgts(this.editTextVrSaldoFgts.getText().toString());

        dados.setDtContratacao(StringUtil.formatStringToDate(this.editTextDtContratacao.getText().toString()));
        dados.setDtDesligamento(StringUtil.formatStringToDate(this.editTextDtDemissao.getText().toString()));

        return dados;
    }

}
