package questao03;

import java.time.LocalDateTime;

public class DespesaComInternet extends Despesa{

    private double dadosTrafegados;

    public DespesaComInternet(LocalDateTime data, String descricao, double dadosTrafegados) {
        super(data, descricao);
        this.dadosTrafegados = dadosTrafegados;
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        if(dadosTrafegados >= 20 && dadosTrafegados < 100)
            total = ((dadosTrafegados - 20) * 3.90) + 90.90;
        else if(dadosTrafegados >= 100 && dadosTrafegados < 500)
            total = ((dadosTrafegados - 100) * 4.40) + 240.90;
        else if(dadosTrafegados >= 500)
            total = ((dadosTrafegados - 500) * 5.10) + 590.90;

        return total;
    }

    @Override
    public String toString() {
        String tela = String.format("%s%n", "/*Internet*/");
        tela += String.format("|Data: %s%n|Descricao: %s%n|Total Dados: %.2f%n", formatarData(), getDescricao(), dadosTrafegados);
        tela += String.format("%s%n%n", "---------------------------------------------");
        return tela;
    }
}
