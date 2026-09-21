## API de Controle de Estoque de Produtos

API REST desenvolvida em Java com Spring Boot para adicionar e remover produtos, consultar estoque e histórico de movimentação de produtos.
Os dados são mantidos em memória RAM durante a execução.

### Tecnologias Utilizadas

* Java 17
* Spring Boot 4.1
* Maven

### Como Executar a Aplicação

A execução pode ser feita pelo CMD (Prompt de Comando), pelo PowerShell ou pelo Terminal integrado da sua IDE (VS Code, IntelliJ IDEA, Eclipse, etc.).

### Pré-requisitos
* Java 17 ou superior instalado.
* Maven instalado (ou utilizar o wrapper `./mvnw`).

### Passo a passo
1. **Clone o repositório:**
   ```bash
   git clone https://github.com/lopes-thais/gerenciador-estoque-produtos.git

2. **Acesse a pasta do projeto**
  ```bash
   cd gerenciador-estoque-produtos
  ```

3. **Inicie a aplicação**
  ```bash
  mvn spring-boot:run
  ```


## Endpoints da API

Headers: Content-Type: application/json

- Certifique-se de primeiro adicionar produtos ao estoque em estoque/adicionar ou os demais endpoints não vão funcionar.

  
### Adicionar produtos ao estoque  
HTTP Method: POST
URL: http://localhost:8082/estoque/adicionar


#### Exemplo de JSON esperado

```bash
{
    "estoque":
    [
        {
            "codigoProduto": 101,
            "descricaoProduto": "Caneta Azul",
            "estoque": 150
        },
        {
            "codigoProduto": 102,
            "descricaoProduto": "Caderno Universitário",
            "estoque": 75
        },
        {
            "codigoProduto": 103,
            "descricaoProduto": "Borracha Branca",
            "estoque": 200
        },
        {
            "codigoProduto": 104,
            "descricaoProduto": "Lápis Preto HB",
            "estoque": 320
        },
        {
            "codigoProduto": 105,
            "descricaoProduto": "Marcador de Texto",
            "estoque": 90
        }
    ]
}
```

- A resposta da API é o mesmo JSON enviado.


### Movimentar o estoque

Para as operações de entrada e saída de produtos, implementei Enums (ENTRADA e SAIDA), certifique-se de ao enviar a requisição escrever corretamente o tipo de movimentação.

HTTP Method: POST

URL: http://localhost:8082/estoque/movimentar


### - Adicionar produtos ao estoque

Exemplo de JSON de entrada esperado

```bash
{
    "codigoProduto": 104,
    "descricaoProduto": "Lápis Preto HB",
    "movimentacao": 70,
    "tipo": "ENTRADA"
}
```


Exemplo de saída esperada

```bash
{
    "codigoProduto": 104,
    "descricaoProduto": "Lápis Preto HB",
    "movimentacao": 70,
    "tipo": "ENTRADA",
    "estoque": 390
}
```


### - Remover produtos do estoque


Exemplo de JSON de entrada esperado

```bash
{
    "codigoProduto": 104,
    "descricaoProduto": "Lápis Preto HB",
    "movimentacao": 70,
    "tipo": "SAIDA"
}
```

Exemplo de saída esperada

```bash
{
    "codigoProduto": 104,
    "descricaoProduto": "Lápis Preto HB",
    "movimentacao": 70,
    "tipo": "SAIDA",
    "estoque": 320
}
```


### - Consultar o estoque

HTTP Method: GET

URL: http://localhost:8082/estoque/consultar


Exemplo de saída esperada

```bash
[
    {
        "codigoProduto": 101,
        "descricaoProduto": "Caneta Azul",
        "estoque": 150
    },
    {
        "codigoProduto": 102,
        "descricaoProduto": "Caderno Universitário",
        "estoque": 75
    },
    {
        "codigoProduto": 103,
        "descricaoProduto": "Borracha Branca",
        "estoque": 200
    },
    {
        "codigoProduto": 104,
        "descricaoProduto": "Lápis Preto HB",
        "estoque": 390
    },
    {
        "codigoProduto": 105,
        "descricaoProduto": "Marcador de Texto",
        "estoque": 90
    }
]
```


### - Consultar histórico de movimentações

HTTP Method: GET

URL: http://localhost:8082/estoque/historico/movimentacoes


Exemplo de saída esperada

```bash
[
    {
        "codigoProduto": 104,
        "descricaoProduto": "Lápis Preto HB",
        "id": 1,
        "movimentacao": 70,
        "tipo": "ENTRADA"
    },
    {
        "codigoProduto": 101,
        "descricaoProduto": "Caneta Azul",
        "id": 2,
        "movimentacao": 70,
        "tipo": "SAIDA"
    }
]
```
