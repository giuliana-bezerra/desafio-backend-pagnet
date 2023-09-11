# Desafio Backend Pagnet

Esse projeto foi desenvolvido usando como base [esse desafio](https://github.com/Pagnet/desafio-back-end/tree/master) para uma vaga backend na Pagnet. A solução desenvolvida nesse subprojeto é o backend e utiliza Spring Batch para o processamento do arquivo CNAB.

## Como Executar
Para executar localmente é necessário ter o [MySQL](https://www.mysql.com) instalado ou executá-lo via Docker, para tal seguir a documentação da ferramenta. Lembrar de ajustar o usuário e senha utilizados e o nome do banco, caso necessário.

- Clonar repositório git:
```
git clone https://github.com/giuliana-bezerra/desafio-backend-pagnet.git
```
- Buildar o projeto:
```
./backend/mvnw clean install -DskipTests -f backend/pom.xml
```
- Executar o projeto:
```
java -jar backend/target/desafio-backend-pagnet-0.0.1-SNAPSHOT.jar
```

## Como Testar

- Upload do arquivo:
```
curl -X POST -F "file=@/path/to/file/CNAB.txt" http://localhost:8080/cnab/upload
``` 
- Lista das operações importadas com totalizador por nome da loja:
```
curl http://localhost:8080/cnab
```

## Decisões de Arquitetura

- O controle de unicidade das transações é feito por arquivo CNAB, o que significa que o processamento das transações é feito apenas uma vez por arquivo.
- O arquivo CNAB deve ser nomeado com um id ou timestamp, pois ele será passado como
parâmetro do job e só pode ser importado uma única vez.
- Caso seja informado um arquivo já importado, deve ser informada uma mensagem de
erro ao usuário.
- Caso haja erro no processamento é possível submeter o mesmo arquivo várias vezes para habilitar o restart de onte o processamento parou.
- Se o arquivo for muito grande, é possível utilizar uma estratégia de particionamento
no job, melhorando assim a performance.