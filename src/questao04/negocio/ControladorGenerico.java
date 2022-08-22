package questao04.negocio;

import questao04.dados.IRepositorioGenerico;
import questao04.dados.RepositorioGenerico;
import questao04.models.*;

import java.time.LocalDate;
import java.util.*;

class ComparadorOferta implements Comparator<OfertaProduto> {
    @Override
    public int compare(OfertaProduto o1, OfertaProduto o2) {
        return o1.compareTo(o2);
    }
}
public class ControladorGenerico {

    private IRepositorioGenerico<Usuario> RepoUsuario;
    private IRepositorioGenerico<AlertaPreco> RepoAlertaPreco;
    private IRepositorioGenerico<Loja> RepoLoja;
    private IRepositorioGenerico<OfertaProduto> RepoOfertaProduto;
    private IRepositorioGenerico<Produto> RepoProduto;

    public ControladorGenerico() {
        RepoUsuario = new RepositorioGenerico<>();
        RepoAlertaPreco = new RepositorioGenerico<>();
        RepoLoja = new RepositorioGenerico<>();
        RepoOfertaProduto = new RepositorioGenerico<>();
        RepoProduto = new RepositorioGenerico<>();
    }


    public List<OfertaProduto> listarOfertasOrdenadasPorPrecoNaData(Produto produto, LocalDate dataAtual) {
        List<OfertaProduto> lista = new ArrayList<>();
        for(OfertaProduto verificar : RepoOfertaProduto.listar()) {
            if(verificar.getProduto().equals(produto) && verificar.getData().equals(dataAtual))
                lista.add(verificar);
        }
        Collections.sort(lista, new ComparadorOferta());
        return lista;
    }
    //Este método atende ao REQ5 e deve implementar a ordenação usando
    // alguma das técnicas já discutidas em aulas (Comparator ou Comparable)
    // O sistema deverá permitir a busca pelos preços de um dado produto na
    // data atual, ordenando-os do menor para o maior.

    public Map<LocalDate, List<OfertaProduto>> montarHistoricoDeOfertasDoProdutoNoPeriodo(Produto produto, LocalDate dataInicial, LocalDate dataFinal) {
        List<OfertaProduto> lista = new ArrayList<>();
        Map<LocalDate, List<OfertaProduto>> mapa = new LinkedHashMap<>();
        for(OfertaProduto verificar : RepoOfertaProduto.listar()) {
            if(verificar.getProduto().equals(produto) && calcularData(dataInicial, dataFinal, verificar.getData())) {
                lista.add(verificar);
            }
        }

        mapa.put(RepoOfertaProduto.listar().get(0).getData(), lista);

        return mapa;
    }

    public List<AlertaPreco> verificarAlertasDePrecoAtingido(Usuario u) {
        List<AlertaPreco> lista = new ArrayList<>();
        LocalDate dataHj = LocalDate.now();
        for (AlertaPreco verificar : RepoAlertaPreco.listar()) {
            if(verificar.getUsuario().equals(u)) {

                for(OfertaProduto oferta : RepoOfertaProduto.listar()) {
                    if(oferta.getData().equals(dataHj) && oferta.getPreco() <= verificar.getPrecoAlvo()) {
                        lista.add(verificar);
                    }
                }
            }
        }
        return lista;
    }

    public boolean calcularData(LocalDate inicio, LocalDate fim, LocalDate data) {
        return data.isAfter(inicio) && data.isBefore(fim);
    }

    public IRepositorioGenerico<Usuario> getRepoUsuario() {
        return RepoUsuario;
    }

    public IRepositorioGenerico<AlertaPreco> getRepoAlertaPreco() {
        return RepoAlertaPreco;
    }

    public IRepositorioGenerico<Loja> getRepoLoja() {
        return RepoLoja;
    }

    public IRepositorioGenerico<OfertaProduto> getRepoOfertaProduto() {
        return RepoOfertaProduto;
    }

    public IRepositorioGenerico<Produto> getRepoProduto() {
        return RepoProduto;
    }
}
