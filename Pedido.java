import exceptions.PedidoVazioException;
        import java.util.HashMap;
        import java.util.Map;

        public class Pedido {
            private Map<Produto, Integer> itens = new HashMap<>();
            private static int contador = 1;
            private final int id;
            private String status;
            private float total;

            public Pedido(Carrinho carrinho) throws PedidoVazioException {
                if (carrinho.getItens().isEmpty()) {
                    throw new PedidoVazioException("Pedido vazio");
                }

                this.id = contador++;
                this.itens = carrinho.getItens();
                this.status = "Processando";
                calcularTotal();
            }

            // Getters
            public int getId() {
                return id;
            }

            public String getStatus() {
                return status;
            }

            public Map<Produto, Integer> getItens() {
                return itens;
            }

            public Map<Produto, Integer> getPedido() {
                return itens;
            }

            // Auxiliary methods
            public float getTotal() {
                return total;
            }

            private void calcularTotal() {
                total = 0;
                for (Map.Entry<Produto, Integer> entry : itens.entrySet()) {
                    total += entry.getKey().getPreco() * entry.getValue();
                }
            }

            public void atualizarStatus(String novoStatus) {
                this.status = novoStatus;
            }

        }