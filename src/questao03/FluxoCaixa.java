package questao03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FluxoCaixa {

    private String nomeEmpresa;
    private String cnpj;
    private List<Transacao> listaTransacao = new ArrayList<>();

//    public FluxoCaixa(String nomeEmpresa, String cnpj, List<Transacao> transacao) {
//        this.nomeEmpresa = nomeEmpresa;
//        this.cnpj = cnpj;
//        this.transacao = transacao;
//    }

        public FluxoCaixa(String nomeEmpresa, String cnpj) {
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
    }

    public void adicionarTransacao(Transacao transacao) {
        listaTransacao.add(transacao);
    }

    public double calcularDespesas(LocalDate inicio, LocalDate fim) {
            double totalDespesas = 0;
            for(Transacao verificar : listaTransacao) {
                if(verificar instanceof Despesa && calcularData(inicio, fim, verificar.getData().toLocalDate())) {
                    totalDespesas += verificar.calcularTotal();
                }
            }
            return totalDespesas;
    }

    public double calcularReceitas(LocalDate inicio, LocalDate fim) {
            double totalDespesas = 0;
            for (Transacao verificar : listaTransacao) {
                if (verificar instanceof Receita && calcularData(inicio, fim, verificar.getData().toLocalDate())) {
                    totalDespesas += verificar.calcularTotal();
                }
            }
            return totalDespesas;
    }

    public double percentualReceitasNoMes(int mes, int ano) {
            double total = 0;
            double totalMes = 0;
            for(Transacao verificar : listaTransacao) {
                if(verificar instanceof Receita && verificar.getData().toLocalDate().getYear() == ano) {
                    total += verificar.calcularTotal();
                }

                if(verificar instanceof Receita && verificar.getData().toLocalDate().getMonthValue() == mes) {
                    totalMes += verificar.calcularTotal();
                }
            }
            return (totalMes * 100)/total;
    }

    public double percentualDespesasNoMes(int mes, int ano) {
        double total = 0;
        double totalMes = 0;
        for(Transacao verificar : listaTransacao) {
            if(verificar instanceof Despesa && verificar.getData().toLocalDate().getYear() == ano) {
                total += verificar.calcularTotal();
            }

            if(verificar instanceof Despesa && verificar.getData().toLocalDate().getMonthValue() == mes) {
                totalMes += verificar.calcularTotal();
            }
        }
        return (totalMes * 100)/total;
    }

    public double saldoAtual() {
            double totalDes = 0;
            double totalRec = 0;
            for (Transacao verificar : listaTransacao) {
                if(verificar instanceof Receita)
                    totalRec += verificar.calcularTotal();
                else if(verificar instanceof Despesa)
                    totalDes += verificar.calcularTotal();
            }
            return totalRec - totalDes;
    }

    public List<Transacao> listarTransacoesNoMes(int mes, int ano) {
            List<Transacao> lista = new ArrayList<>();
            for (Transacao verificar : listaTransacao) {
                if(verificar.getData().toLocalDate().getMonthValue() == mes && verificar.getData().toLocalDate().getYear() == ano)
                    lista.add(verificar);
            }
            return lista;
    }

    public boolean calcularData(LocalDate inicio, LocalDate fim, LocalDate data) {
            return data.isAfter(inicio) && data.isBefore(fim);
    }
}