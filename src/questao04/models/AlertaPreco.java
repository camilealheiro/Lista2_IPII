package questao04.models;

public class AlertaPreco {

    private Usuario usuario;
    private Produto produto;
    private float precoAlvo;

    public AlertaPreco(Usuario usuario, Produto produto, float precoAlvo) {
        this.usuario = usuario;
        this.produto = produto;
        this.precoAlvo = precoAlvo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public float getPrecoAlvo() {
        return precoAlvo;
    }

    public void setPrecoAlvo(float precoAlvo) {
        this.precoAlvo = precoAlvo;
    }

    public boolean equals(AlertaPreco alerta) {
        return usuario.equals(alerta.getUsuario()) && produto.equals(alerta.getProduto()) && precoAlvo == alerta.getPrecoAlvo();
    }

    @Override
    public String toString() {
        String tela = String.format("%s%n", "/*Alerta*/");
        tela += usuario.toString() + produto + "|Preco Alvo: " + precoAlvo;
        return tela;
    }
}
