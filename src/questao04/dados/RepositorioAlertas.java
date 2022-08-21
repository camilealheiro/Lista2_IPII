package questao04.dados;

import questao04.exceptions.PrecoInvalidoException;
import questao04.models.AlertaPreco;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioAlertas {

    private ArrayList<AlertaPreco> alertas = new ArrayList<>();

    public void salvarAlerta(AlertaPreco ap) throws PrecoInvalidoException {
        if (ap != null && ap.getPrecoAlvo() < 0) {
            throw new PrecoInvalidoException(ap.getPrecoAlvo());
            // daqui para baixo nada mais é executado
        }

        alertas.add(ap);
    }

    public List<AlertaPreco> listarAlertasPreco() {
        return Collections.unmodifiableList(this.alertas);
    }

    // CRUD
    // create
    // recover
    // update
    // delete
}
