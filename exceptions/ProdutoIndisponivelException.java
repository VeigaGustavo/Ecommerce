package exceptions;

// Exceção para quando um produto está indisponível em estoque
public class ProdutoIndisponivelException extends Exception {
    public ProdutoIndisponivelException(String mensagem) {
        super(mensagem);
    }
}
