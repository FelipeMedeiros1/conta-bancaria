package banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Conta> contas = new ArrayList<>();

        int opcao ;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar Conta Corrente");
            System.out.println("2 - Cadastrar Conta Poupança");
            System.out.println("3 - Ver contas cadastradas");
            System.out.println("4 - Ver extrato");
            System.out.println("5 - Depositar");
            System.out.println("6 - Sacar");
            System.out.println("7 - Transferir");
            System.out.println("8 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> new CadastrarConta().cadastrarContaCorrente(scanner, contas);
                case 2 -> new CadastrarConta().cadastrarContaPoupanca(scanner, contas);
                case 3 -> new CadastrarConta().verContasCadastradas(contas);
                case 4 -> new CadastrarConta().extrato(scanner, contas);
                case 5 -> new CadastrarConta().realizarDeposito(scanner, contas);
                case 6 -> new CadastrarConta().realizarSaque(scanner, contas);
                case 7 -> new CadastrarConta().realizarTransferencia(scanner, contas);
                case 8 -> System.out.println("Encerrando o programa.");
                default -> System.out.println("Opção inválida. Escolha uma opção válida.");
            }
        } while (opcao != 8);

        scanner.close();
    }




}
