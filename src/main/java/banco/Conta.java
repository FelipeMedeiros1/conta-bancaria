package banco;

import java.util.Objects;

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


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Cliente getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(Cliente nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return numero == conta.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}
