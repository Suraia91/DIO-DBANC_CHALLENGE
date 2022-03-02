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
import com.suraia.banc.model.Cliente;
import com.suraia.banc.model.Conta;
import com.suraia.banc.model.ContaCorrente;
import com.suraia.banc.model.ContaPoupanca;

import java.util.ArrayList;
import java.util.List;



public class DepositoFragment extends Fragment {
    private double saldo;
    ArrayAdapter<String> adapter;
    List<String> stringList= new ArrayList<>();
    Cliente Test= new Cliente();
    Conta conta =new ContaPoupanca(Test);
    Conta cc =new ContaCorrente(Test);

    private FragmentDepositoBinding depBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         depBinding=FragmentDepositoBinding.inflate(inflater, container, false);
         adapter=new ArrayAdapter<String>(getContext(),
                 android.R.layout.simple_list_item_1, stringList);
         depBinding.lvDeposito.setAdapter(adapter);
        depBinding.btnDep.setOnClickListener(view->deposit(getContext()));
        return depBinding.getRoot();
    }
     void deposit(Context context){

        if (depBinding.edtDepvapor.getText().toString().isEmpty()){
            Toast.makeText(context,"O valor nao pode ser nulo",Toast.LENGTH_SHORT).show();
        }
        else {
           saldo +=Double.parseDouble(depBinding.edtDepvapor.getText().toString());
           depBinding.tvDepvapor.setText(String.valueOf(saldo));
            conta.depositar(Double.parseDouble(depBinding.edtDepvapor.getText().toString()));
            stringList.add( "Deposito: " + depBinding.edtDepvapor.getText().toString());
            stringList.add("===Extrato conta Corrente===\n" +
                    "Titular:"+Test.getNome()+"\n" +
                    "Agencia:"+cc.getAgencia()+"\n" +
                    "Conta:"+cc.getNumero()+"\n" +
                    "Saldo:"+cc.getSaldo());

            stringList.add("======Extrato conta Poupanca======\n" +
                    "Titular:"+Test.getNome()+"\n" +
                    "Agencia:"+conta.getAgencia()+"\n" +
                    "Conta:"+conta.getNumero()+"\n" +
                    "Saldo:"+conta.getSaldo());
            adapter.notifyDataSetChanged();
            cc.imprimirExtrato();
            conta.imprimirExtrato();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        depBinding=null;
    }

}
