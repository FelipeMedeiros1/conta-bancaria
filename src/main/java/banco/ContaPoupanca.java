package banco;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(int numero, String agencia, Cliente nomeCliente, double saldo) {
        super(numero, agencia, nomeCliente, saldo);
    }

    @Override
    public Conta criarConta(int numero, String agencia, Cliente nomeCliente, double saldo) {
        return new ContaPoupanca(numero,agencia,nomeCliente,saldo);
    }

}
