# Prova de Conceito: CQRS e Event Sourcing

Este repositório contém uma prova de conceito (POC) criada para explorar e entender os conceitos de CQRS (Command Query Responsibility Segregation) e Event Sourcing. O objetivo é demonstrar como essas abordagens podem ser aplicadas em uma arquitetura de sistema para melhorar a escalabilidade, a performance e a capacidade de auditoria.

## Tecnologias Utilizadas

- **Linguagem**: Java 17
- **Framework**: Spring Boot 2.7.6
- **Framework de CQRS e Event Sourcing**: Axon Framework
- **Banco de Dados**: PostgreSQL (utilizado como Event Store)
- **Containerização**: Docker e Docker Compose

## Estrutura do Projeto

- `command/`: Contém a lógica relacionada aos comandos (escritas). Este serviço recebe os comandos do usuário, valida e persiste os eventos correspondentes.
- `query/`: Contém a lógica para consultas (leituras). Este serviço consome os eventos e atualiza as visões materializadas do estado para permitir consultas eficientes.

## Como Executar

### Pré-requisitos

- Docker e Docker Compose instalados
- JDK 17 instalado
- Maven instalado

### Passos

1. **Clonar o Repositório**

    ```bash
    git clone https://github.com/LeoRBlume/cqrs-eventsource-poc.git
    cd cqrs-eventsource-poc.git
    ```

2. **Construir o Projeto**

   Execute o comando Maven para compilar o projeto e criar os artefatos necessários:

    ```bash
    mvn clean install
    ```

3. **Subir os Serviços com Docker Compose**

   Utilize o Docker Compose para iniciar os containers necessários:

    ```bash
    docker-compose up -d
    ```
4. Acessar http://localhost:8024 e dar um complete na instalação.

5. **Acessar os Endpoints**

   - O serviço de comando estará disponível em: POST `http://localhost:8080/order`
   - O serviço de consulta estará disponível em: GET `http://localhost:8081/order/{orderId}`

## Conceitos Explorados

### CQRS (Command Query Responsibility Segregation)

CQRS é uma abordagem que separa a leitura (queries) e a escrita (commands) de um sistema. Essa separação permite que cada lado seja escalado de forma independente e otimizado de acordo com suas necessidades específicas.

### Event Sourcing

Event Sourcing é um padrão de design onde o estado de um sistema é determinado a partir de uma sequência de eventos. Ao invés de persistir apenas o estado atual, todos os eventos que levaram ao estado atual são armazenados, permitindo a reconstrução do estado em qualquer ponto do tempo.

### Axon Framework

O Axon Framework é uma plataforma especializada para construir aplicações baseadas em CQRS e Event Sourcing. Ele facilita a implementação desses padrões, fornecendo infraestrutura para o manuseio de comandos, eventos e consultas, bem como a comunicação entre componentes distribuídos.

