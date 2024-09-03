# Usar uma imagem base do OpenJDK
FROM eclipse-temurin:17

# Definir o diretório de trabalho
WORKDIR /app

# Copiar o arquivo JAR gerado para o container
COPY target/poc-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta que o aplicativo vai usar
EXPOSE 8080

# Comando para executar o aplicativo
CMD ["java", "-jar", "app.jar"]
