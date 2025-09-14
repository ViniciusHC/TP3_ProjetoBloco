import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Produto> produtosEmEstoque = new ArrayList<Produto>();

        Produto produtos1 = new Produto();
        produtosEmEstoque = produtos1.lerProdutos();
        Cliente cliente1 = new Cliente("Joao", 1234, "joao@", "040506");
        cliente1.fazerLogin("joao@", "040506");

        ArrayList<ItensCarrinho> carrinhoFinal = adicionarNoCarrinho(produtosEmEstoque);
        FormaPagamento metodoPagamento = new FormaPagamento(definirPagamento());

        Pedido pedidoFinal = new Pedido (cliente1, carrinhoFinal, metodoPagamento);
        System.out.println(pedidoFinal);
        pedidoFinal.gravarArquivo(pedidoFinal);

    }

    public static ArrayList<ItensCarrinho> adicionarNoCarrinho(List<Produto> produtosEmEstoque){
        Scanner scanner = new Scanner(System.in);
        ArrayList<ItensCarrinho> produtosNoCarrinho = new ArrayList<ItensCarrinho>();
        int quantidadeCarrinho;

        System.out.println("Digite a opcao desejada:\n1- Adicionar produtos \n0- Sair");
        int opcao = scanner.nextInt();

        while(opcao != 0){

            System.out.println("Digite o id do produto que deseja adicionar ao carrinho: ");
            int id = scanner.nextInt();
            Produto produtoEncontrado = verificarExistencia(id, produtosEmEstoque);

            if (produtoEncontrado != null){
                System.out.println("Digite a quantidade do Produto: ");
                quantidadeCarrinho = scanner.nextInt();

                if(verificarEstoque(quantidadeCarrinho, produtoEncontrado)){
                    ItensCarrinho itemNoCarrinho = new ItensCarrinho(produtoEncontrado.getId(), produtoEncontrado.getNome(), produtoEncontrado.getPreco(), quantidadeCarrinho);

                    if(produtoJaNoCarrinnho(produtoEncontrado, produtosNoCarrinho, quantidadeCarrinho)){
                        System.out.println("Quantidade do carrinho atualizado!");
                    } else{
                        System.out.println("Produto "+produtoEncontrado.getNome()+" no valor de R$ "+produtoEncontrado.getPreco()+", adicionado ao carrinho!");
                        itemNoCarrinho.calcularPrecoTotal();
                        produtosNoCarrinho.add(itemNoCarrinho);
                    }
                }else {
                    System.out.println("Produto não possui estoque suficiente! Há "+produtoEncontrado.getQuantidade()+" "+produtoEncontrado.getNome()+"(s) em estoque");
                }

            }else {
                System.out.println("Produto não encontrado com id "+id);
            }

            System.out.println("Digite a opcao desejada:\n1- Adicionar produtos \n0- Sair");
            opcao = scanner.nextInt();
        }

        return produtosNoCarrinho;
    }

    public static Produto verificarExistencia(int id, List<Produto> produtosEmEstoque){
        Produto produtoEncontrado = null;

        for (Produto produto : produtosEmEstoque){
            if (id == produto.getId()){
                produtoEncontrado = produto;
            }
        }
        return produtoEncontrado;
    }

    public static boolean verificarEstoque(int quantidadeCarrinho, Produto produtoEncontrado){
        boolean quantidadeSuficiente = false;
        int quantidadeEstoque = produtoEncontrado.getQuantidade();

        if (quantidadeCarrinho <= quantidadeEstoque && quantidadeEstoque > 0){
            quantidadeSuficiente = true;
        }
        return quantidadeSuficiente;
    }

    public static boolean produtoJaNoCarrinnho(Produto produtoEncontrado, ArrayList<ItensCarrinho> produtosNoCarrinho, int quantidadeCarrinho){
        boolean produtoJaNoCarrinho = false;

        for (ItensCarrinho produtoNoCarrinho : produtosNoCarrinho){
            if (produtoEncontrado.getId() == produtoNoCarrinho.getId()){
                int quantidadeNoCarrinho = produtoNoCarrinho.getQuantidade();
                produtoNoCarrinho.setQuantidade(quantidadeNoCarrinho + quantidadeCarrinho);
                produtoNoCarrinho.calcularPrecoTotal();
                produtoJaNoCarrinho = true;
            }
        }
        return produtoJaNoCarrinho;
    }

    public static String definirPagamento(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a forma de pagamento(Pix/Cartao/Boleto): ");
        String formarPagamento = scanner.nextLine();
        return formarPagamento;
    }
}
