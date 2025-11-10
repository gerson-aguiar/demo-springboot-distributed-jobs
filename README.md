Estou criando um servidor de jobs com SpringBoot 3 + Java 21 + MySQL.

Considere um escopo de empresa fintech.

Objetivos:
V0:
- Criar um jobs que roda a cada 1 segundo e atualiza alguma tabela no banco de dados

V1:
Objetivo: Testar um cenario com duas instancias da aplicação rodando, deve gerar algum tipo de insconsitencia.
Então migrar para uma solução que comporte jobs distribuidos sem concorrencia.



EN:

I'm creating a job server using Spring Boot 3 + Java 21 + MySQL.
Considerer a fintech company scope.

V0
    Objective: Create a job that runs every 1 second and updates a table in the database.

V1:
    Objective: Test a scenario with two instances of the application running, it should generate
    some king of inconsistency.
    Then migrate to a solution that supports distributed jobs without concurrency issues.