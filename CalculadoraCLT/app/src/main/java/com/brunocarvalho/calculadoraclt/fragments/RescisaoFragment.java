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
import com.brunocarvalho.calculadoraclt.negocio.to.CalculadoraTO;
import com.brunocarvalho.calculadoraclt.util.ConstantsUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by carva on 13/05/2017.
 */

public class RescisaoFragment extends Fragment {

    private DatePickerDialog datePickerContratacao;
    private DatePickerDialog datePickerDemissao;

    private EditText editTextDtContratacao;
    private EditText editTextMotivo;
    private EditText editTextAviso;
    private EditText editTextDtDemissao;

    private Spinner spinnerMotivo;
    private Spinner spinnerAviso;

    private Button btnCalcular;

    private SimpleDateFormat sdf;

    private View rootView;
    private InputMethodManager imm;

    private String[] motivoList = {"Dispensa sem Justa Causa", "Dispensa com Justa Causa", "Pedido de demissão", "Contrato de experiência no prazo", "Contrato de experiência antes do prazo", "Aposentadoria do empregado", "Falecimento do empregador"};
    String[] avisoList = {"Trabalhado", "Indenizado pelo empregador", "Não cumprido pelo empregado", "Dispensado"};

    public RescisaoFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_rescisao, container, false);

        String myFormat = "dd/MM/yyyy";
        sdf = new SimpleDateFormat(myFormat, Locale.US);

        findViews(rootView);

        createListeners();

        setDateTimeField();

        ArrayAdapter<String> adapterMotivo = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, motivoList);
        spinnerMotivo.setAdapter(adapterMotivo);

        ArrayAdapter<String> adapterAviso = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, avisoList);
        spinnerAviso.setAdapter(adapterAviso);

        return rootView;
    }

    private void findViews(View view) {
        editTextDtContratacao = (EditText) view.findViewById(R.id.edit_text_dt_contratacao);
        editTextDtContratacao.setInputType(InputType.TYPE_NULL);

        editTextDtDemissao = (EditText) view.findViewById(R.id.edit_text_dt_demissao);
        editTextDtDemissao.setInputType(InputType.TYPE_NULL);

        editTextMotivo = (EditText) view.findViewById(R.id.edit_text_motivo);
        editTextMotivo.setInputType(InputType.TYPE_NULL);

        editTextAviso = (EditText) view.findViewById(R.id.edit_text_aviso);
        editTextAviso.setInputType(InputType.TYPE_NULL);

        spinnerMotivo = (Spinner) view.findViewById(R.id.spinner_motivo);
        spinnerAviso = (Spinner) view.findViewById(R.id.spinner_aviso);

        btnCalcular = (Button) view.findViewById(R.id.btn_calcular_rescisao);

        imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    private void setDateTimeField() {
        Calendar newCalendar = Calendar.getInstance();
        datePickerContratacao = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                editTextDtContratacao.setText(sdf.format(newDate.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDemissao = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                editTextDtDemissao.setText(sdf.format(newDate.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

    }

    private void createListeners() {
        // EditText Contratação listener
        editTextDtContratacao.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    imm.hideSoftInputFromWindow(rootView.getWindowToken(), 0);
                    datePickerContratacao.show();
                }
            }
        });

        editTextDtContratacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imm.hideSoftInputFromWindow(rootView.getWindowToken(), 0);
                datePickerContratacao.show();
            }
        });

        // EditText Demissão listener
        editTextDtDemissao.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    imm.hideSoftInputFromWindow(rootView.getWindowToken(), 0);
                    datePickerDemissao.show();
                }
            }
        });

        editTextDtDemissao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imm.hideSoftInputFromWindow(rootView.getWindowToken(), 0);
                datePickerDemissao.show();
            }
        });

        // EditText Motivo listener
        editTextMotivo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    imm.hideSoftInputFromWindow(rootView.getWindowToken(), 0);
                    spinnerMotivo.performClick();
                }
            }
        });

        editTextMotivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imm.hideSoftInputFromWindow(rootView.getWindowToken(), 0);
                spinnerMotivo.performClick();
            }
        });

        // EditText Aviso listener
        editTextAviso.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    imm.hideSoftInputFromWindow(rootView.getWindowToken(), 0);
                    spinnerAviso.performClick();
                }
            }
        });

        editTextAviso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imm.hideSoftInputFromWindow(rootView.getWindowToken(), 0);
                spinnerAviso.performClick();
            }
        });

        // Spinner's
        spinnerMotivo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                editTextMotivo.setText(spinnerMotivo.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                editTextMotivo.setText("");
            }
        });

        spinnerAviso.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                editTextAviso.setText(spinnerAviso.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                editTextAviso.setText("");
            }
        });

        // Button Calcular
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final CalculadoraTO result = new CalculadoraTO();
                result.setTituloResultado("Rescisao");

                Intent intent = new Intent(getActivity(), ResultActivity.class);
                intent.putExtra(ConstantsUtil.RESULTADO, result);

                startActivity(intent);
            }
        });

    }

}
