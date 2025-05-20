![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![RabbitMQ](https://img.shields.io/badge/Rabbitmq-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white)

# Microserviços com RabbitMq

# Projeto Pedidos Recebidos

Projeto desenvolvido durante treinamento da JDevTreinamentos com objetivo de aprofundar conhecimentos sobre Mensageria com RabbitMq.

### Tecnologias utilizadas
- Java
- Spring Boot
- Docker
- RabbitMq
- Banco de dados Postgres

### Arquitetura do projeto

O MicroServiço 'pedidos-api' recebe o Pedido via requisição no
Endpoint '/api/v1/pedidos'
que enviará esse pedido para o RabbitMq

No RabbitMq teremos uma exchange do tipo fanout
Com duas filas para notificação e para processamento.

As filas ligam a cada MicroServiço que desenpenha:
Notificação - recebe a mensagem e envia um email simulado via mailhog.
Processamento - recebe a mensagem e persiste o pedido em banco de dados.

Configurado uma 'dead-letter-exchange' para que caso um pedido não passe em uma possível validação no Ms de notificação o mesmo seja encaminhado
para uma 'fila morta' e possa ser efetuado outro processamento em momento oportuno.

![image](https://github.com/user-attachments/assets/b089d1c3-cac4-4f41-a3ce-29976cafb291)

![image](https://github.com/user-attachments/assets/b9917591-61ec-4608-aa8e-9de3ddfc593a)


# Para acessar:
Inicie os containers docker com 'docker compose up -d'

Acesse o painel de administracao do banco utilizando o PgAdmin:
Acesso configurado no docker compose file.
````
http://localhost:5050/browser/
````
Aqui configure uma conexão com o banco de dados desta maneira:
Botao direito sobre servers:

![image](https://github.com/user-attachments/assets/66aecff7-2e20-454e-90d7-45f2733374ba)

De um nome a sua conexão e vá para aba de conexão que deverá ficar assim:

![image](https://github.com/user-attachments/assets/39d5b32c-567b-4e5d-aa3a-4b6b616d6920)

Adicione o projeto na sua IDE.
Projeto estruturado em módulos.
Entre na classe main de cada projeto e execute nesta ordem.

![image](https://github.com/user-attachments/assets/5389e7de-494d-4eb4-9d70-14e745739478)

Inicie a aplicação 'pedidos-api'
Inicie a aplicação 'notificacao'
Inicie a aplicação 'processador'

Para acessar documentação no Swagger utilize: 'http://localhost:8282/swagger-ui.html'
Segue um exemplo de payload de pedido para teste.

````
{
    "id": 109,
    "cliente": "Samuel Borges",
    "itens": [
        {
            "quantidade": 2,
            "produto": {
                "id": 2,
                "nome": "Produto teste",
                "valor": 35.00
            }
        }
    ],
    "valorTotal": 61.00,
    "emailNotificacao": "teste@teste.com"
}
````

Após executar o envio do pedido poderá verificar no banco o mesmo salvo.

