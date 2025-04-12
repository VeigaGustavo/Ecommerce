package exceptions;

// Exceção para quando um produto já está no carrinho
public class ProdutoJaExisteNoCarrinhoException extends Exception {
    public ProdutoJaExisteNoCarrinhoException(String mensagem) {
        super(mensagem);
    }
}
