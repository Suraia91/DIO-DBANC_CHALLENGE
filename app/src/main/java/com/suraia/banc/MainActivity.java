package com.suraia.banc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.suraia.banc.model.Cliente;
import com.suraia.banc.model.Conta;
import com.suraia.banc.model.ContaCorrente;
import com.suraia.banc.model.ContaPoupanca;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}