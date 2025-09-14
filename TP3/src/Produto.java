import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Produto {

    private String nome;
    private int id;
    private float preco;
    private int quantidade;

    public Produto(int id, String nome, float preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Produto(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Produto> lerProdutos(){
        String Arquivo = "Produtos.csv";
        ArrayList<Produto> produtosEmEstoque = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(Arquivo));
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] produtos = linha.split(";");

                Produto produtoLido = new Produto();
                produtoLido.setId(Integer.parseInt(produtos[0]));
                produtoLido.setNome(produtos[1]);
                produtoLido.setQuantidade(Integer.parseInt(produtos[2]));
                produtoLido.setPreco(Float.parseFloat(produtos[3]));
                produtosEmEstoque.add(produtoLido);
            }
            br.close();
        }
        catch (IOException e) {
            System.out.println("Erro: leitura do arquivo");
        }
        return produtosEmEstoque;
    }

}
