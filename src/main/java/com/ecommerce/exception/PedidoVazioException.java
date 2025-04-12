package exceptions;

// Exceção para quando um pedido está vazio
public class PedidoVazioException extends Exception {
    public PedidoVazioException(String mensagem) {
        super(mensagem);
    }
}
