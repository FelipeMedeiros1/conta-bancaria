package banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static banco.CadastroConta.*;

public class ContaTerminal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Conta> contas = new ArrayList<>();

        int opcao;
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
                case 1:
                    cadastrarContaCorrente(scanner, contas);
                    break;
                case 2:
                    cadastrarContaPoupanca(scanner, contas);
                    break;
                case 3:
                    verContasCadastradas(contas);
                    break;
                case 4:
                    extrato(scanner, contas);
                    break;
                case 5:
                    realizarDeposito(scanner, contas);
                    break;
                case 6:
                    realizarSaque(scanner, contas);
                    break;
                case 7:
                    realizarTransferencia(scanner, contas);
                    break;
                case 8:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha uma opção válida.");
                    break;
            }
        } while (opcao != 8);

        scanner.close();
    }

}
