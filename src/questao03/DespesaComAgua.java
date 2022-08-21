package questao03;

import java.time.LocalDateTime;

public class DespesaComAgua extends Despesa{

    private double totalM3;

    public DespesaComAgua(LocalDateTime data, String descricao, double totalM3) {
        super(data, descricao);
        this.totalM3 = totalM3;
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        if(totalM3 >= 0 && totalM3 <= 10)
            total = 45;
        else if(totalM3 > 10 && totalM3 <= 20)
            total = ((totalM3 - 10) * 5) + 45;
        else if(totalM3 > 20)
            total = ((totalM3 - 20) * 6) + 95;

        return total;
    }

    @Override
    public String toString() {
        String tela = String.format("%s%n", "/*Agua*/");
        tela += String.format("|Data: %s%n|Descricao: %s%n|Total M3: %.2f%n", formatarData(), getDescricao(), totalM3);
        tela += String.format("%s%n%n", "---------------------------------------------");
        return tela;
    }
}
