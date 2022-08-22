package questao04.main;

import questao04.exceptions.ElementoJaExisteException;
import questao04.models.*;
import questao04.negocio.ControladorGenerico;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class TesteMain {

    public static void main(String[] args) throws ElementoJaExisteException {

        Usuario u1 = new Usuario("camile@123", "Camile", LocalDate.of(2003, 3,12));
        Usuario u2 = new Usuario("Carol@123", "Caroline", LocalDate.of(1994, 7, 1));

        Produto p1 = new Produto("123", "Teclado", "Teclado Gamer", CategoriaProdutoEnum.ELETRONICOS);
        Produto p2 = new Produto("456", "Blusa", "Rosa", CategoriaProdutoEnum.VESTUARIO);
        Produto p3 = new Produto("456", "Blusa", "Rosa", CategoriaProdutoEnum.VESTUARIO);

        AlertaPreco a1 = new AlertaPreco(u1, p1, 120);
        AlertaPreco a2 = new AlertaPreco(u1, p2, 30);
        AlertaPreco a3 = new AlertaPreco(u2, p1, 100);

        Loja l1 = new Loja("234", "Casas Bahia", "www.CasasBahia");
        Loja l2 = new Loja("435", "Amazon", "www.Amazon");
        Loja l3 = new Loja("564", "Americanas", "www.Americanas");

        OfertaProduto o1 = new OfertaProduto(p1, 115, l1, LocalDate.of(2022, 8, 18));
        OfertaProduto o2 =new OfertaProduto(p2, 35, l2, LocalDate.of(2022, 8, 19));
        OfertaProduto o3 = new OfertaProduto(p1, 110, l2, LocalDate.of(2022, 8, 20));
        OfertaProduto o4 = new OfertaProduto(p2, 20, l3, LocalDate.of(2022, 8,15));
        OfertaProduto o5 = new OfertaProduto(p1, 105, l1, LocalDate.now());

        ControladorGenerico controlador = new ControladorGenerico();

        try {
            controlador.getRepoUsuario().inserir(u1);
            controlador.getRepoUsuario().inserir(u2);
            controlador.getRepoProduto().inserir(p1);
            controlador.getRepoProduto().inserir(p2);
            //controlador.getRepoProduto().inserir(p3);

            controlador.getRepoAlertaPreco().inserir(a1);
            controlador.getRepoAlertaPreco().inserir(a2);
            controlador.getRepoAlertaPreco().inserir(a3);

            controlador.getRepoLoja().inserir(l1);
            controlador.getRepoLoja().inserir(l2);
            controlador.getRepoLoja().inserir(l3);

            controlador.getRepoOfertaProduto().inserir(o1);
            controlador.getRepoOfertaProduto().inserir(o2);
            controlador.getRepoOfertaProduto().inserir(o3);
            controlador.getRepoOfertaProduto().inserir(o4);
            controlador.getRepoOfertaProduto().inserir(o5);
        }
        catch (ElementoJaExisteException jaExiste) {
            jaExiste.printStackTrace();
        }


        System.out.println("***************Listar Ofertas Ordenadas***************");
        List<OfertaProduto> lista1 = controlador.listarOfertasOrdenadasPorPrecoNaData(p1, LocalDate.of(2022, 8, 20));
        for(OfertaProduto verificar : lista1) {
            System.out.println(verificar);
        }

        System.out.println("***************Montar Historico***************");
        Map<LocalDate, List<OfertaProduto>> mapa1 = controlador.montarHistoricoDeOfertasDoProdutoNoPeriodo(p1, LocalDate.of(2022, 8, 17), LocalDate.of(2022,8,21));
        for(Map.Entry<LocalDate, List<OfertaProduto>> entry : mapa1.entrySet()) {
            System.out.println("|Data: " + entry.getKey() + "\n" + entry.getValue());
        }


        System.out.println("***************Verificar Alerta***************");
        List<AlertaPreco> alerta1 = controlador.verificarAlertasDePrecoAtingido(u1);
        for(AlertaPreco verificar : alerta1) {
            System.out.println(verificar);
        }

    }
}
