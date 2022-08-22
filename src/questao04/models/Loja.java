package questao04.models;

public class Loja {

    private String id;
    private String nome;
    private String endSite;

    public Loja(String id, String nome, String endSite) {
        this.id = id;
        this.nome = nome;
        this.endSite = endSite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndSite() {
        return endSite;
    }

    public void setEndSite(String endSite) {
        this.endSite = endSite;
    }

    @Override
    public String toString() {
        String tela = String.format("%n%s%n", "/*Loja*/");
        tela += String.format("|ID: %s%n|Nome: %s%n|Site: %s%n", id, nome, endSite);
        return tela;
//        return "Loja [id=" + id + ", nome=" + nome + ", endSite=" + endSite
//                + "]";
    }
}
