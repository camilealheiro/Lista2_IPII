package questao02;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public abstract class Pessoa {

    private String nome;
    private LocalDate dataNascimento;

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return String.format("|Nome: %s%n|Data de Nascimento: %s", nome, formatarData());
    }

    public boolean equals(Pessoa outraPessoa) {
        return nome.equals(outraPessoa.nome) && dataNascimento.equals(outraPessoa.dataNascimento);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int idade() {
        LocalDate dataHj = LocalDate.now();
        Period periodo = Period.between(dataNascimento, dataHj);
        return periodo.getYears();
    }

    public String formatarData() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatador.format(dataNascimento);
    }
}
