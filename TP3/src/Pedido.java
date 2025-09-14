import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;

public class Pedido {
    private Cliente cliente;
    private ArrayList<ItensCarrinho> itensCarrinho;
    private FormaPagamento formaPagamento;

    public Pedido(Cliente cliente, ArrayList<ItensCarrinho> itensCarrinho, FormaPagamento formaPagamento) {
        this.cliente = cliente;
        this.itensCarrinho = itensCarrinho;
        this.formaPagamento = formaPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ItensCarrinho> getItensCarrinho() {
        return itensCarrinho;
    }

    public void setItensCarrinho(ArrayList<ItensCarrinho> itensCarrinho) {
        this.itensCarrinho = itensCarrinho;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void gravarArquivo(Pedido pedidoFinal) {
        String Arquivo = "Pedidos.csv";
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Arquivo), "UTF-8"));
            bw.write("Cliente; Produto; Quantidade; Preço Unitário; Preço Total; Forma de Pagamento");
            bw.newLine();

            for (ItensCarrinho produto : itensCarrinho) {
                bw.write(
                cliente.getNome() + ";" +
                    produto.getNome() + ";" +
                    produto.getQuantidade() + ";" +
                    produto.getPreco() + ";" +
                    produto.getPrecoTotal() + ";" +
                    formaPagamento.getFormaPagamento()
                );
            bw.close();
            }
        }
        catch (IOException e) {
            System.out.println("Erro ao gravar arquivo");
        }}

    @Override
    public String toString() {
        String mensagem;

        mensagem = "Pedido: \nCliente: "+cliente.getNome()+"\nPedido: ";
        for (ItensCarrinho produto : itensCarrinho){
            mensagem += produto+"/";
        }
        mensagem += "\nForma de pagamento: "+formaPagamento.getFormaPagamento();

        return mensagem;
    }
}
