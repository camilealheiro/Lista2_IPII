package questao03;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Receita implements Transacao{

    private LocalDateTime data;
    private String descricao;

    public Receita(LocalDateTime data, String descricao) {
        this.data = data;
        this.descricao = descricao;
    }

    public String getTipo() {
        return "RECEITA";
    }

    @Override
    public abstract double calcularTotal();

    @Override
    public LocalDateTime getData() {
        return data;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    public String formatarData() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatador.format(data);
    }
}
