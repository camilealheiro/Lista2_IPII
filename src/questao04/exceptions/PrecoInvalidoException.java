package questao04.exceptions;

public class PrecoInvalidoException extends Exception {

    private float precoAlvoInvalido;

    public PrecoInvalidoException(float preco) {
        this.precoAlvoInvalido = preco;
    }

    public float getPrecoAlvoInvalido() {
        return precoAlvoInvalido;
    }
}
