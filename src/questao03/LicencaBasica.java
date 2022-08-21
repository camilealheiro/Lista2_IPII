package questao03;

import java.time.LocalDateTime;

public class LicencaBasica extends Receita{

    private int totalContas;

    public LicencaBasica(LocalDateTime data, String descricao, int totalContas) {
        super(data, descricao);
        this.totalContas = totalContas;
    }

    @Override
    public double calcularTotal(){
        return totalContas * 20;
    }

    @Override
    public String toString() {
        String tela = String.format("%s%n", "/*Licenca Basica*/");
        tela += String.format("|Data: %s%n|Descricao: %s%n|Total de Contas: %d%n", formatarData(), getDescricao(), totalContas);
        tela += String.format("%s%n%n", "---------------------------------------------");
        return tela;
    }
}
