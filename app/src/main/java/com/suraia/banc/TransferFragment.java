package com.suraia.banc;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.suraia.banc.databinding.FragmentSaqueBinding;
import com.suraia.banc.databinding.FragmentTransferBinding;
import com.suraia.banc.model.Cliente;
import com.suraia.banc.model.Conta;
import com.suraia.banc.model.ContaCorrente;
import com.suraia.banc.model.ContaPoupanca;

import java.util.ArrayList;
import java.util.List;

public class TransferFragment extends Fragment {
    ArrayAdapter<String> adapter;
    List<String> stringList = new ArrayList<>();
    Cliente Test = new Cliente();
    Conta conta = new ContaPoupanca(Test);
    Conta cc = new ContaCorrente(Test);
    private FragmentTransferBinding transferBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        transferBinding = FragmentTransferBinding.inflate(inflater, container, false);
        adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, stringList);
        transferBinding.lvTransfer.setAdapter(adapter);
        transferBinding.btnTrans.setOnClickListener(view -> transfer(getContext()));
        return transferBinding.getRoot();
    }

    void transfer(Context context) {
        if (transferBinding.edtTransfer.getText().toString().isEmpty() || transferBinding.edtValor.getText().toString().isEmpty()) {
            Toast.makeText(context, "Os campos nao podem ser nulos", Toast.LENGTH_SHORT).show();
        } else {
            cc.depositar(Double.parseDouble(transferBinding.edtValor.getText().toString()));
            cc.transferir(Double.parseDouble(transferBinding.edtValor.getText().toString()), conta);
            Toast.makeText(context, "Transferencia feita com sucesso", Toast.LENGTH_SHORT).show();
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
        transferBinding = null;
    }
}