package com.suraia.banc;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.suraia.banc.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {
    private FragmentMainBinding mainBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainBinding = FragmentMainBinding.inflate( inflater,container, false);

        mainBinding.btnDeposito.setOnClickListener(view -> gotoDep(this));
        mainBinding.btnSaque.setOnClickListener(view -> gotoSaque(this));
        mainBinding.btnTransferencia.setOnClickListener(view -> gotoTrans(this));
        mainBinding.btnExtrato.setOnClickListener(view -> gotoExtract(this));
        return mainBinding.getRoot();

    }
    private void gotoDep(Fragment view){
        NavHostFragment.findNavController(view).navigate(R.id.action_mainFragment_to_depositoFragment);
    }
    private void gotoSaque(Fragment view){
        NavHostFragment.findNavController(view).navigate(R.id.action_mainFragment_to_saqueFragment);

    }
    private void gotoTrans(Fragment view){
        NavHostFragment.findNavController(view).navigate(R.id.action_mainFragment_to_transferFragment);
    }
    private void gotoExtract(Fragment view){
        NavHostFragment.findNavController(view).navigate(R.id.action_mainFragment_to_extratoFragment);
    }

}