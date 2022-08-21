package questao03;

import java.time.LocalDateTime;

public class DespesaComEnergia extends Despesa{

    private double kWh;

    public DespesaComEnergia(LocalDateTime data, String descricao, double kWh) {
        super(data, descricao);
        this.kWh = kWh;
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        int adicional = (int)kWh/100;;
        if(kWh >= 0 && kWh <= 50)
            total = (kWh * 0.5) + 2;
        else if(kWh > 50 && kWh <= 200)
            total = (kWh * 0.5) + 15 + (adicional * 1.2);
        else if (kWh > 200)
            total = (kWh * 0.5) + 35 + (adicional * 1.2);

        return total;
    }

    @Override
    public String toString() {
        String tela = String.format("%s%n", "/*Energia*/");
        tela += String.format("|Data: %s%n|Descricao: %s%n|Total kWh: %.2f%n", formatarData(), getDescricao(), kWh);
        tela += String.format("%s%n%n", "---------------------------------------------");
        return tela;
    }
}
