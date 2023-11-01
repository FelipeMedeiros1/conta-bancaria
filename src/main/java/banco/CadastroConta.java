package banco;

import java.util.List;
import java.util.Scanner;

public class CadastroConta {

    public static  void cadastrarConta(Scanner scanner, List<Conta> contas) {
        System.out.println("**************************************************************************");

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
        System.out.println("**************************************************************************");

        if (contaExistente) {
            System.out.println("Essa conta já existe. Não é possível cadastrá-la novamente.");
            System.out.println("**************************************************************************");
        } else {
            Cliente cliente = new Cliente(nomeCliente);
            Conta conta = new Conta(numero, agencia, cliente, saldo);
            contas.add(conta);
            System.out.println("Conta cadastrada com sucesso.");
            System.out.println("Olá " + conta.getNomeCliente().getNome() + ",\nobrigado por criar uma conta em nosso banco,\nsua agência é "
                    + conta.getAgencia() + ", conta " + conta.getNumero() + " \ne o saldo de R$ " + conta.getSaldo() + " já está disponível para saque.");
            System.out.println("**************************************************************************");
        }
    }

    public static void verContasCadastradas(List<Conta> contas) {
        System.out.println("**************************************************************************");
        System.out.println("Contas cadastradas:");

        contas.forEach(conta -> {
            System.out.println("Nome do Cliente: " + conta.getNomeCliente().getNome());
            System.out.println("Agência: " + conta.getAgencia());
            System.out.println("Número da Conta: " + conta.getNumero());
            System.out.println("Saldo: R$" + conta.getSaldo());
            System.out.println();
            System.out.println("**************************************************************************");
        });
    }


}
