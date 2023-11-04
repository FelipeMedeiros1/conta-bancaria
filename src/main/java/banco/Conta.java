package banco;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;
@Getter
@EqualsAndHashCode
public abstract  class Conta implements IConta {
    private int numero;
    private String agencia;
    private Cliente nomeCliente;
    private double saldo;

    public Conta(int numero, String agencia, Cliente nomeCliente, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
    }
    public abstract Conta criarConta(int numero, String agencia, Cliente nomeCliente, double saldo);

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("SAQUE REALIZADO COM SUCESSO.");
        } else {
            System.out.println("SALDO INSUFICIENTE.");
        }
    }
    public void depositar(double valor) {
        saldo += valor;
    }

}
