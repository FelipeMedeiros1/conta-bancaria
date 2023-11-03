package banco;

public class ContaCorrente extends Conta{
    public ContaCorrente(int numero, String agencia, Cliente nomeCliente, double saldo) {
        super(numero, agencia, nomeCliente, saldo);
    }

    @Override
    public Conta criarConta(int numero, String agencia, Cliente nomeCliente, double saldo) {
        return new ContaCorrente(numero,agencia,nomeCliente,saldo);
    }

}
