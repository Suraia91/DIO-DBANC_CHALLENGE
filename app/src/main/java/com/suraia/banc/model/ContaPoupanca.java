package com.suraia.banc.model;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public void imprimirExtrato() {
        System.out.println("===extrato conta Poupanca===");
        super.imprimirExtrato();
    }
}
