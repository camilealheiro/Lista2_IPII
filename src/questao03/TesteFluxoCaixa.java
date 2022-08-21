package questao03;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TesteFluxoCaixa {

    public static void main(String[] args) {

        FluxoCaixa f1 = new FluxoCaixa("Empresa1", "1234-09");

        Transacao d1 = new DespesaComAgua(LocalDateTime.of(2022, 2, 13, 14, 34), "Agua do Banho", 32);
        Transacao d2 = new DespesaComEnergia(LocalDateTime.of(2022, 3, 24, 18, 54), "Energia Gereal", 300);
        Transacao d3 = new DespesaComInternet(LocalDateTime.of(2021, 6, 20, 12, 36), "Internet Norte", 600);
        f1.adicionarTransacao(d1);
        f1.adicionarTransacao(d2);
        f1.adicionarTransacao(d3);

        Transacao r1 = new LicencaEnterprise(LocalDateTime.of(2021, 6, 16, 17, 49), "Licenca da Empresa B", 6);
        Transacao r2 = new LicencaBasica(LocalDateTime.of(2022, 3, 15, 19, 44), "Licenca da Empresa F", 10);
        Transacao r3 = new LicencaEnterprise(LocalDateTime.of(2022, 4, 22, 20, 56), "Licenca da Empresa G", 4);
        f1.adicionarTransacao(r1);
        f1.adicionarTransacao(r2);
        f1.adicionarTransacao(r3);

        System.out.printf("Despesas Totais Entre: %.2f%n", f1.calcularDespesas(LocalDate.of(2021, 6, 19), LocalDate.of(2022, 2, 21)));
        System.out.printf("Receitas Totais Entre: %.2f%n", f1.calcularReceitas(LocalDate.of(2021, 6, 19), LocalDate.of(2022, 2, 21)));
        System.out.printf("Percentual Receitas: %.2f%n", f1.percentualReceitasNoMes(6, 2021));
        System.out.printf("Percentual Dispesas: %.2f%n", f1.percentualDespesasNoMes(3, 2022));
        System.out.printf("Saldo Atual: %.2f%n", f1.saldoAtual());

        List<Transacao> lista = f1.listarTransacoesNoMes(6, 2021);
        System.out.println(lista);
    }
}
