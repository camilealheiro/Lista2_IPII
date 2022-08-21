package questao02;

import java.time.LocalDate;

public class Cliente extends Pessoa{

    private long codigo;

    public Cliente(String nome, LocalDate dataNascimento, long codigo) {
        super(nome, dataNascimento);
        this.codigo = codigo;
    }

    public String toString() {

        String tela = String.format("%s%n", "/*Cliente*/");
        tela += String.format("|Nome do Cliente: %s%n|Data de Nascimento: %s%n|Codigo do Cliente: %d%n", getNome(), formatarData(), codigo);
        tela += String.format("%s", "-----------------------------------------------");
        return tela;

    }

    public boolean equals(Cliente outroCliente) {
        return getNome().equals(outroCliente.getNome()) && getDataNascimento().equals(outroCliente.getDataNascimento()) && codigo == outroCliente.codigo;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }
}
