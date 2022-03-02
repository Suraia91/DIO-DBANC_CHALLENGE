package com.suraia.banc.model;

public class ContaCorrente extends Conta{


    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    public void imprimirExtrato() {
        System.out.println("===extrato conta Corrente===");
        super.imprimirExtrato();
    }
}
