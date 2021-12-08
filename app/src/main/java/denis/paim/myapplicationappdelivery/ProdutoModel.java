package denis.paim.myapplicationappdelivery;


public class ProdutoModel {

    private Integer imagem;
    private String nome;
    private float preco;
    private int totalNoCarrinho;

    public ProdutoModel(Integer imagem, String nome, float preco) {
        this.imagem = imagem;
        this.nome = nome;
        this.preco = preco;
    }


    public int getTotalNoCarrinho() {
        return totalNoCarrinho;
    }

    public void setTotalNoCarrinho(int totalNoCarrinho) {
        this.totalNoCarrinho = totalNoCarrinho;
    }

    public Integer getImagem() {
        return imagem;
    }

    public void setImagem(Integer imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

}
