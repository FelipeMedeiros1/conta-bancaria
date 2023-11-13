package banco;

import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.Getter;


@Getter
public class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nomeCliente) {
        this.nome = nomeCliente;
    }

}