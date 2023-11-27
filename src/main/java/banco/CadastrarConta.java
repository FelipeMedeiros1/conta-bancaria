package banco;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CadastrarConta {
    private static final String SEPARADOR = "**************************************************************************";

    private void cadastrarConta(Scanner scanner, List<Conta> contas, String tipoConta) {
        System.out.println(SEPARADOR);

        System.out.print("NÚMERO DA AGÊNCIA: ");
        String agencia = scanner.nextLine();

        System.out.print("NÚMERO DA CONTA: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.print("NOME DO CLIENTE: ");
        String nomeCliente = scanner.nextLine();

        System.out.print("SALDO INICIAL: ");
        double saldo = scanner.nextDouble();
        scanner.nextLine();

        boolean contaExistente = contas.stream().anyMatch(conta -> conta.getNumero() == numero);
        System.out.println(SEPARADOR);

        if (contaExistente) {
            System.out.println("Essa conta já existe. Não é possível cadastrá-la novamente.");
            System.out.println(SEPARADOR);
        } else {
            Cliente cliente = new Cliente(nomeCliente);
            Conta conta = criarConta(tipoConta, numero, agencia, cliente, saldo);
            contas.add(conta);
            System.out.println("Conta cadastrada com sucesso.");
            mostrarDadosConta(conta);
            System.out.println(SEPARADOR);
        }
    }

    private void mostrarDadosConta(Conta conta) {
        System.out.println("Olá " + conta.getNomeCliente().getNome() + ",\nsua agência é: "
                + conta.getAgencia() + ", \nnúmero da conta: " + conta.getNumero() + " \ne o saldo de R$ " + conta.getSaldo() + " já está disponível para saque.");
    }

    private Conta criarConta(String tipoConta, int numero, String agencia, Cliente cliente, double saldo) {
        if (tipoConta.equals("corrente")) {
            return new ContaCorrente(numero, agencia, cliente, saldo);
        } else if (tipoConta.equals("poupanca")) {
            return new ContaPoupanca(numero, agencia, cliente, saldo);
        } else {
            throw new IllegalArgumentException("Tipo de conta desconhecido: " + tipoConta);
        }
    }

    public void cadastrarContaCorrente(Scanner scanner, List<Conta> contas) {
        System.out.println("Cadastrar Conta Corrente");
        cadastrarConta(scanner, contas, "corrente");
        System.out.println(SEPARADOR);
    }

    public void cadastrarContaPoupanca(Scanner scanner, List<Conta> contas) {
        System.out.println("Cadastrar Conta Poupança");
        cadastrarConta(scanner, contas, "poupanca");
        System.out.println(SEPARADOR);
    }

    public void verContasCadastradas(List<Conta> contas) {
        System.out.println(SEPARADOR);
        System.out.println("Contas cadastradas:");
        System.out.println(SEPARADOR);

        contas.forEach(conta -> {
            System.out.println("Nome do Cliente: " + conta.getNomeCliente().getNome());
            System.out.println("Agência: " + conta.getAgencia());
            System.out.println("Número da Conta: " + conta.getNumero());
            System.out.println("Saldo: " + conta.getSaldo());
            System.out.println(SEPARADOR);
        });
    }

    public void realizarDeposito(Scanner scanner, List<Conta> contas) {
        System.out.print("NÚMERO DA CONTA PARA DEPÓSITO: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine();

        Optional<Conta> contaEncontrada = contas.stream().filter(conta -> conta.getNumero() == numeroConta).findFirst();

        if (contaEncontrada.isPresent()) {
            Conta conta = contaEncontrada.get();
            System.out.print("VALOR A SER DEPOSITADO: ");
            double valorDeposito = scanner.nextDouble();
            scanner.nextLine();
            conta.depositar(valorDeposito);
            System.out.println("DEPÓSITO REALIZADO COM SUCESSO.");
        } else {
            System.out.println("CONTA NÃO ENCONTRADA.");
        }
        System.out.println(SEPARADOR);
    }

    public void realizarSaque(Scanner scanner, List<Conta> contas) {
        System.out.print("NÚMERO DA CONTA PARA SAQUE: ");
        int numeroConta = scanner.nextInt();
        scanner.nextLine();

        Optional<Conta> contaEncontrada = contas.stream().filter(conta -> conta.getNumero() == numeroConta).findFirst();

        if (contaEncontrada.isPresent()) {
            Conta conta = contaEncontrada.get();
            System.out.print("VALOR DO SAQUE: ");
            double valorSaque = scanner.nextDouble();
            scanner.nextLine();
            conta.sacar(valorSaque);

        } else {
            System.out.println("CONTA NÃO ENCONTRADA.");
        }
        System.out.println(SEPARADOR);
    }

    public void realizarTransferencia(Scanner scanner, List<Conta> contas) {
        System.out.println(SEPARADOR);
        System.out.print("NÚMERO DA CONTA DE ORIGEM: ");
        int numeroContaOrigem = scanner.nextInt();
        scanner.nextLine();

        System.out.print("NÚMERO DA CONTA DE DESTINO: ");
        int numeroContaDestino = scanner.nextInt();
        scanner.nextLine();

        Optional<Conta> contaOrigem = contas.stream().filter(conta -> conta.getNumero() == numeroContaOrigem).findFirst();

        Optional<Conta> contaDestino = contas.stream().filter(conta -> conta.getNumero() == numeroContaDestino).findFirst();

        if (contaOrigem.isPresent() && contaDestino.isPresent()) {
            Conta origem = contaOrigem.get();
            Conta destino = contaDestino.get();
            System.out.print("VALOR A SER TRANSFERIDO: ");
            double valorTransferencia = scanner.nextDouble();
            scanner.nextLine();

            if (origem.getSaldo() >= valorTransferencia) {
                origem.sacar(valorTransferencia);
                destino.depositar(valorTransferencia);
                System.out.println("TRANSFERÊNCIA REALIZADA COM SUCESSO.");
            } else {
                System.out.println("SALDO INSUFICIENTE PARA TRANSFERIR.");
            }
        } else {
            System.out.println("CONTA DE ORIGEM OU CONTA DE DESTINO NÃO ENCONTRADA.");
        }
        System.out.println(SEPARADOR);
    }

    public void extrato(Scanner scanner, List<Conta> contas) {
        System.out.println(SEPARADOR);
        System.out.print("NÚMERO DA CONTA: ");
        int numeroContaProcurada = scanner.nextInt();
        scanner.nextLine();

        Optional<Conta> extrato = contas.stream().filter(conta -> conta.getNumero() == numeroContaProcurada).findFirst();

        if (extrato.isPresent()) {
            Conta conta = extrato.get();
            mostrarDadosConta(conta);
            System.out.println(SEPARADOR);
        } else {
            System.out.println("Conta não encontrada.");
            System.out.println(SEPARADOR);
        }
    }


}
