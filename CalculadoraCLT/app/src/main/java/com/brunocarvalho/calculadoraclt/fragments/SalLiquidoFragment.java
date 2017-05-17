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

import com.brunocarvalho.calculadoraclt.R;
import com.brunocarvalho.calculadoraclt.ResultActivity;

/**
 * Created by carva on 13/05/2017.
 */

public class SalLiquidoFragment extends Fragment {

    private Button btnCalcular;

    private InputMethodManager imm;

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

        return rootView;
    }

    private void findViews(View view) {
        btnCalcular = (Button) view.findViewById(R.id.btn_calcular_sal_liquido);

        imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    private void createListeners() {
        // Button Calcular
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ResultActivity.class));
            }
        });
    }

}
