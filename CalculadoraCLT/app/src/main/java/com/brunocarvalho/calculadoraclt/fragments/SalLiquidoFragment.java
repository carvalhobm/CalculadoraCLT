package com.brunocarvalho.calculadoraclt.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brunocarvalho.calculadoraclt.R;

/**
 * Created by carva on 13/05/2017.
 */

public class SalLiquidoFragment extends Fragment {

    public SalLiquidoFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sal_liquido, container, false);
    }
}
