# API REST – Gerenciamento de Filmes e Diretores
Projeto desenvolvido com Java + Spring Boot, utilizando arquitetura REST, persistência com JPA/Hibernate e banco de dados relacional.
O objetivo é demonstrar a construção de uma API simples com dois modelos principais – Filme e Diretor – e operações CRUD completas.


## Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Postgres
- Postman para testes
- Gradle

```
src/main/java
 └── controller/      → Camada de entrada HTTP (REST)
 └── entity/          → Modelos JPA e mapeamento das tabelas
 └── repository/      → Interfaces de acesso ao banco
 └── service/         → Lógica de negócio
```

### Modelos de Dados
#### Filme
Representa um filme armazenado no sistema.

Atributos:

- `id` (Long)
- `titulo` (String)
- `genero` (String)
- `anoLancamento` (String)
- `diretor` (ManyToOne → Diretor)
  
#### Diretor
Atributos:

- `id` (Long)
- `nome` (String)
- `nacionalidade` (String)

## Endpoints
### Endpoints de Filmes

| Método | Rota        | Descrição             |
|--------|-------------|------------------------|
| POST   | /criarFilme | Criar um novo filme    |
| GET    | /           | Listar todos os filmes |
| GET    | /{id}       | Buscar filme por ID    |
| PUT    | /{id}       | Atualizar filme        |
| DELETE | /{id}       | Deletar filme          |


### Endpoints de Diretores

| Método | Rota           | Descrição                                           |
|--------|----------------|------------------------------------------------------|
| POST   | /criarDiretor  | Criar um diretor                                    |
| GET    | /              | Listar diretores                                    |
| GET    | /{id}          | Buscar diretor por ID                                |
| DELETE | /{id}          | Remover diretor (somente se não houver filmes associados) |



## Exemplos de Requisições
### Criar Diretor (POST /diretor/criarDiretor)

```bash
{
  "nome": "James Wan",
  "nacionalidade": "Australiano"
}
```

### Criar Filme (POST /filmes/criarFilme)

``` bash 
{
  "titulo": "Invocação do Mal",
  "genero": "Terror",
  "anoLancamento": "2013",
  "diretor": {
    "id": 1
  }
}
```
## Validações e Regras Implementadas

- Filme não pode ser criado sem título.
- Diretor só pode ser removido se não tiver filmes associados.
- Atualização parcial de filme (PUT).
- Tratamento de erros com ResponseEntity.


