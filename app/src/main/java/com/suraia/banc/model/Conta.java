package com.suraia.banc.model;

import java.util.Locale;

public class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    private final Cliente cliente;

    protected int agencia;
    protected int numero;
    protected double saldo;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;

    }
    public void sacar() {
    }
    public void depositar() {

    }
    public void transferir() {
    }

    public int getAgencia() {
        return agencia;
    }
    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo =+valor;
    }

    @Override
    public void transferir(double valor, Conta contadestino) {
        this.sacar(valor);
        contadestino.depositar(valor);
    }
    @Override
    public void imprimirExtrato() {
        System.out.println("Titular:" + this.cliente.getNome());
        System.out.printf(Locale.US, "Agencia: %d%n", this.agencia);
        System.out.printf(Locale.US, "conta: %d%n", this.numero);
        System.out.printf(Locale.US, "saldo: %.2f%n",
                this.saldo);
    }
}
