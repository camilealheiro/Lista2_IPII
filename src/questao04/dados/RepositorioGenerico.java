package questao04.dados;

import questao04.exceptions.ElementoJaExisteException;
import questao04.exceptions.ElementoNaoExisteException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioGenerico<T> implements IRepositorioGenerico<T>{

    protected List<T> elementos;

    public RepositorioGenerico() {
        this.elementos = new ArrayList<>();
    }

    public void inserir(T novoObj) throws ElementoJaExisteException {
        if(!elementos.contains(novoObj))
            elementos.add(novoObj);
        else
            throw new ElementoJaExisteException(novoObj);
    }

    @Override
    public List<T> listar() {
        return Collections.unmodifiableList(elementos);
    }

    public void remover(T obj) throws ElementoNaoExisteException {
        if(elementos.contains(obj))
            elementos.remove(elementos.indexOf(obj));
        else
            throw new ElementoNaoExisteException(obj);
    }

    public void atualizar(T newObj) throws ElementoNaoExisteException {
        if(elementos.contains(newObj)) {
            int i = elementos.indexOf(newObj);
            elementos.set(i, newObj);
        }
        else
            throw new ElementoNaoExisteException(newObj);
    }
}
