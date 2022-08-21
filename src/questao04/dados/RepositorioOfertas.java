package questao04.dados;

import questao04.models.OfertaProduto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioOfertas {

    private ArrayList<OfertaProduto> ofertasProdutos = new ArrayList<>();

    public void salvar(OfertaProduto op) {
        this.ofertasProdutos.add(op);
    }

    public List<OfertaProduto> listarOfertasProdutos() {
        return Collections.unmodifiableList(this.ofertasProdutos);
    }
}
