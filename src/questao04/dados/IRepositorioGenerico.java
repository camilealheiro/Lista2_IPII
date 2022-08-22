package questao04.dados;

import questao04.exceptions.ElementoJaExisteException;
import questao04.exceptions.ElementoNaoExisteException;
import java.util.List;
public interface IRepositorioGenerico<T> {

    void inserir(T obj) throws ElementoJaExisteException;

    List<T> listar();

    void remover(T obj) throws ElementoNaoExisteException;

    void atualizar(T newObj) throws ElementoNaoExisteException;
}
