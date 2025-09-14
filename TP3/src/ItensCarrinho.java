import java.util.ArrayList;
import java.util.List;

public class ItensCarrinho extends Produto{

    private float precoTotal;

    public ItensCarrinho(int id, String nome, float preco, int quantidade) {
        super(id, nome, preco, quantidade);
    }

    public float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }

    public void calcularPrecoTotal (){
        this.precoTotal = getQuantidade() * getPreco();
    }

    @Override
    public String toString() {
        return getNome()+", quantidade: "+getQuantidade()+", no valor total de R$"+precoTotal;
    }
}
