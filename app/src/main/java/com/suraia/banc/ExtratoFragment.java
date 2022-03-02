package com.suraia.banc;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.suraia.banc.databinding.FragmentEXtratoBinding;
import com.suraia.banc.databinding.FragmentTransferBinding;
import com.suraia.banc.model.Cliente;
import com.suraia.banc.model.Conta;
import com.suraia.banc.model.ContaCorrente;
import com.suraia.banc.model.ContaPoupanca;

import java.util.ArrayList;
import java.util.List;

public class ExtratoFragment extends Fragment {
    ArrayAdapter<String> adapter;
    List<String> stringList = new ArrayList<>();
    Cliente Test = new Cliente();
    Conta conta = new ContaPoupanca(Test);
    Conta cc = new ContaCorrente(Test);
    private FragmentEXtratoBinding extratoBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        extratoBinding = FragmentEXtratoBinding.inflate(inflater, container, false);
        adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, stringList);
        extratoBinding.lvExtrato.setAdapter(adapter);
        extrato();
        return extratoBinding.getRoot();
    }

    void extrato() {
            cc.depositar(1000);
            cc.sacar(500);
            cc.transferir(200, conta);

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
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        extratoBinding = null;
    }
}