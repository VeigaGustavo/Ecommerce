# Sistema de E-commerce

Sistema de e-commerce desenvolvido em Java para gerenciamento de produtos, clientes, carrinhos e pedidos.

## Estrutura do Projeto

```
src/main/java/com/ecommerce/
├── config/         # Configurações do sistema
├── controller/     # Controladores da aplicação
├── exception/      # Exceções personalizadas
├── model/          # Modelos de domínio
├── repository/     # Repositórios de dados
├── service/        # Serviços de negócio
├── util/           # Utilitários
└── view/           # Interface com o usuário
```

## Funcionalidades

- Gerenciamento de Clientes
- Gerenciamento de Produtos
- Gerenciamento de Carrinhos
- Gerenciamento de Pedidos
- Categorias de Produtos (Eletrônicos, Livros, Roupas)

## Requisitos

- Java 17
- Maven

## Como Executar

1. Clone o repositório
2. Execute `mvn clean install`
3. Execute a classe `com.ecommerce.view.Main`

## Desenvolvimento

O projeto segue os princípios de arquitetura limpa e separação de responsabilidades, com uma estrutura organizada em camadas:

- **Model**: Classes de domínio que representam as entidades do negócio
- **Controller**: Controladores que gerenciam o fluxo da aplicação
- **Service**: Serviços que implementam a lógica de negócio
- **Repository**: Repositórios para acesso e persistência de dados
- **View**: Interface com o usuário
- **Exception**: Tratamento de exceções personalizadas 