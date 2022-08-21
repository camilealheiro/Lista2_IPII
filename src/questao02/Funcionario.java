package questao02;

import java.time.LocalDate;

public class Funcionario extends Pessoa{

    protected static final double SALARIO_TETO_IMPOSTO = 1900.90;
    private double salario;


    public Funcionario(String nome, LocalDate dataNascimento, double salario) {
        super(nome, dataNascimento);
        this.salario = salario;
    }

    public double calcularImpostoDevido() {
        if(salario <= SALARIO_TETO_IMPOSTO)
            return (0.05 * salario);
        else
            return (0.075 * salario);
    }

    public String toString() {
        String tela = String.format("%s%n", "/*Funcionario*/");
        tela += String.format("|Nome do Funcionario: %s%n|Data de Nascimento:%s%n|Salario do Funcionario: %.2f%n" , getNome(), formatarData(), salario);
        tela += String.format("%s", "-----------------------------------------------");
        return tela;
    }

    public boolean equals(Funcionario outroFuncionario) {
        return getNome().equals(outroFuncionario.getNome()) && getDataNascimento().equals(outroFuncionario.getDataNascimento()) && salario == outroFuncionario.salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
