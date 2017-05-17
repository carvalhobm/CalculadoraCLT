package com.brunocarvalho.calculadoraclt;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.brunocarvalho.calculadoraclt.fragments.RescisaoFragment;
import com.brunocarvalho.calculadoraclt.negocio.to.ResultadoTO;

public class ResultActivity extends AppCompatActivity {

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
        final ResultadoTO resultado = (ResultadoTO) intent.getSerializableExtra(RescisaoFragment.RESULTADO);

        textViewTituloResultado.setText(resultado.getTituloResultado());
    }

    private void findViews(){
        textViewTituloResultado = (TextView) findViewById(R.id.text_view_titulo_resultado);
    }

}
