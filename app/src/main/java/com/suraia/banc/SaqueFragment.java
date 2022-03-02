package com.suraia.banc;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.suraia.banc.databinding.FragmentDepositoBinding;
import com.suraia.banc.databinding.FragmentSaqueBinding;
import com.suraia.banc.model.Cliente;
import com.suraia.banc.model.Conta;
import com.suraia.banc.model.ContaCorrente;
import com.suraia.banc.model.ContaPoupanca;

import java.util.ArrayList;
import java.util.List;

public class SaqueFragment extends Fragment {
    ArrayAdapter<String> adapter;
    List<String> stringList = new ArrayList<>();
    Cliente Test = new Cliente();
    Conta conta = new ContaPoupanca(Test);
    Conta cc = new ContaCorrente(Test);

    private FragmentSaqueBinding sacBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        sacBinding = FragmentSaqueBinding.inflate(inflater, container, false);
        adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, stringList);
        addValue();
        sacBinding.lvSacar.setAdapter(adapter);
        sacBinding.btnSac.setOnClickListener(view -> sacar(getContext()));
        return sacBinding.getRoot();
    }

    void addValue() {
        stringList.add("2000");
        cc.depositar(2000);
    }

    void sacar(Context context) {
        if (sacBinding.edtSacar.getText().toString().isEmpty()) {
            Toast.makeText(context, "O valor nao pode ser nulo", Toast.LENGTH_SHORT).show();
        } else {
            cc.sacar(Double.parseDouble(sacBinding.edtSacar.getText().toString()));
            adapter.remove(sacBinding.edtSacar.getText().toString());
            stringList.add("===Extrato conta Corrente===\n" +
                    "Titular:" + Test.getNome() + "\n" +
                    "Agencia:" + cc.getAgencia() + "\n" +
                    "Conta:" + cc.getNumero() + "\n" +
                    "Saldo:" + cc.getSaldo());

            stringList.add("======Extrato conta Poupanca======\n" +
                    "Titular:" + Test.getNome() + "\n" +
                    "Agencia:" + conta.getAgencia() + "\n" +
                    "Conta:" + conta.getNumero() + "\n" +
                    "Saldo:" + conta.getSaldo());
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        sacBinding = null;
    }
}