public class Produto {
    private String nome;
    private double preco;
    private String descricao;
    private String status; // Novo atributo

    // Construtor da classe pai
    public Produto(String nome, double preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.status = "Disponível"; // Status inicial
    }

    // Getters & Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Methods
    @Override
    public String toString() {
        return ", preco=" + preco +
                ", status='" + status + '\'' +
                '}';
    }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
    }
}

// Subclasses
class Livros extends Produto {
    private String autor;
    private String editora;

    public Livros(String nome, float preco, String descricao, String autor, String editora) {
        super(nome, preco, descricao);
        this.autor = autor;
        this.editora = editora;
    }

    // Getters and Setters
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    @Override
    public String toString() {
        return super.toString() + ", Autor: " + autor + ", Editora: " + editora;
    }
}

class Eletronicos extends Produto {
    private String marca;
    private String garantia;

    public Eletronicos(String nome, float preco, String descricao, String marca, String garantia) {
        super(nome, preco, descricao);
        this.marca = marca;
        this.garantia = garantia;
    }

    // Getters and Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    @Override
    public String toString() {
        return super.toString() + ", Marca: " + marca + ", Garantia: " + garantia;
    }
}

class Roupas extends Produto {
    private String tamanho;
    private String cor;

    public Roupas(String nome, float preco, String descricao, String tamanho, String cor) {
        super(nome, preco, descricao);
        this.tamanho = tamanho;
        this.cor = cor;
    }

    // Getters and Setters
    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tamanho: " + tamanho + ", Cor: " + cor;
    }
}