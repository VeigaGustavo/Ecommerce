import exceptions.PedidoVazioException;
import exceptions.ProdutoJaExisteNoCarrinhoException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Carrinho {
    private Map<Produto, Integer> itens = new HashMap<>();

    public Carrinho(Produto produtoInicial) {
        if (produtoInicial != null) {
            itens.put(produtoInicial, 1);
        }
    }

    public void adicionarProduto(Produto produto) throws ProdutoJaExisteNoCarrinhoException {
        if (itens.containsKey(produto)) {
            throw new ProdutoJaExisteNoCarrinhoException("Produto já existe no carrinho");
        }
        itens.put(produto, 1);
    }

    public void limparCarrinho() {
        itens.clear();
    }

    public Map<Produto, Integer> getItens() {
        return itens;
    }

    public void removerProduto(Produto produto) {
        itens.remove(produto);
    }

    public Map<Produto, Integer> getProdutos() {
        return itens;
    }
}