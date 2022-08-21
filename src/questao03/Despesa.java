package questao03;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Despesa implements Transacao{

    private LocalDateTime data;
    private String descricao;

    public Despesa(LocalDateTime data, String descricao) {
        this.data = data;
        this.descricao = descricao;
    }

    @Override
    public String getTipo() {
        return "DESPESA";
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
