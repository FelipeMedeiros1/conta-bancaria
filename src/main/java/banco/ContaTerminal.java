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
            System.out.println("1 - Cadastrar conta");
            System.out.println("2 - Ver contas cadastradas");
            System.out.println("3 - Buscar conta por número");
            System.out.println("4 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    cadastrarConta(scanner, contas);
                    break;
                case 2:
                    verContasCadastradas(contas);
                    break;
                case 3:
                    buscarPorNumeroDaConta(scanner,  contas);
                    break;
                case 4:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha uma opção válida.");
                    break;
            }
        }while (opcao !=4);

        scanner.close();
    }

}
