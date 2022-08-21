package questao02;

import java.time.LocalDate;

public class Gerente extends Funcionario{

    private String area;

    public Gerente(String nome, LocalDate dataNascimento, double salario, String area) {
        super(nome, dataNascimento, salario);
        this.area = area;
    }

    public String toString() {
        String tela = String.format("%s%n", "/*Gerente*/");
        tela += String.format("|Nome do Gerente: %s%n|Data de Nascimento: %s%n|Salario do Gerente: %.2f%n|Area do Gerente: %s%n", getNome(), formatarData(), getSalario(), area);
        tela += String.format("%s", "-----------------------------------------------");
        return tela;
    }

    public boolean equals(Gerente outroGerente) {
        return getNome().equals(outroGerente.getNome()) && getDataNascimento().equals(outroGerente.getDataNascimento()) && getSalario() == outroGerente.getSalario() && area.equals(outroGerente.area);
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
