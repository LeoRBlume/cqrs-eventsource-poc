# Prova de Conceito: CQRS e Event Sourcing

Este repositório contém uma prova de conceito (POC) criada para explorar e entender os conceitos de CQRS (Command Query Responsibility Segregation) e Event Sourcing. O objetivo é demonstrar como essas abordagens podem ser aplicadas em uma arquitetura de sistema para melhorar a escalabilidade, a performance e a capacidade de auditoria.

## Tecnologias Utilizadas

- **Linguagem**: Java 17
- **Framework**: Spring Boot 3.3.2
- **Banco de Dados**: PostgreSQL (utilizado como Event Store)
- **Mensageria**: Apache Kafka (para processamento assíncrono de eventos)

## Estrutura do Projeto

- `command-service/`: Contém a lógica relacionada aos comandos (escritas). Este serviço recebe os comandos do usuário, valida e persiste os eventos correspondentes.
- `query-service/`: Contém a lógica para consultas (leituras). Este serviço consome os eventos e atualiza as visões materializadas do estado para permitir consultas eficientes.
- `event-store/`: Implementação do armazenamento de eventos utilizando PostgreSQL, permitindo o versionamento e a reconstrução do estado atual.
- `kafka/`: Configuração do Kafka para lidar com a publicação e consumo de eventos entre os serviços de comando e consulta.

## Como Executar

### Pré-requisitos

- Docker e Docker Compose instalados
- JDK 17 instalado
- Maven instalado

### Passos

1. **Clonar o Repositório**

    ```bash
    git clone https://github.com/seu-usuario/poc-cqrs-event-sourcing.git
    cd poc-cqrs-event-sourcing
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

4. **Acessar os Endpoints**

    - O serviço de comando estará disponível em: `http://localhost:8080`
    - O serviço de consulta estará disponível em: `http://localhost:8081`

## Conceitos Explorados

### CQRS (Command Query Responsibility Segregation)

CQRS é uma abordagem que separa a leitura (queries) e a escrita (commands) de um sistema. Essa separação permite que cada lado seja escalado de forma independente e otimizado de acordo com suas necessidades específicas.

### Event Sourcing

Event Sourcing é um padrão de design onde o estado de um sistema é determinado a partir de uma sequência de eventos. Ao invés de persistir apenas o estado atual, todos os eventos que levaram ao estado atual são armazenados, permitindo a reconstrução do estado em qualquer ponto do tempo.

## Contribuições

Sinta-se à vontade para fazer um fork deste repositório e enviar pull requests. Sugestões, issues e discussões são bem-vindas.

## Licença

Este projeto está licenciado sob os termos da licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.



http://localhost:8024