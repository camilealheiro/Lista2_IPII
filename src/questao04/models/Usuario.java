package questao04.models;

import java.time.LocalDate;

public class Usuario {

    private String email;
    private String nome;
    private LocalDate dataNascimento;

    public Usuario(String email, String nome, LocalDate dataNascimento) {
        this.email = email;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public boolean equals(Usuario outroUsuario) {
        return email.equals(outroUsuario.getEmail()) && nome.equals(outroUsuario.getNome()) && dataNascimento.equals(outroUsuario.getDataNascimento());
    }

    @Override
    public String toString() {
        String tela = String.format("%n%s%n", "/*Usuario*/");
        //tela += String.format("|Produto: %s%n|Preco: %", )
        tela += "|Nome: " + nome + "\n|Email = " + email + "\n|Data = " + dataNascimento + "\n";
        return tela;
    }
}
