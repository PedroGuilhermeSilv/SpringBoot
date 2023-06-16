# Desenvolvimento de uma API REST para um fragmento de um sistema de Gerenciamento de Campeonato de Futebol
> Usando o flywaydb você pode apenas mudar os parametros de driver de banco de dados e conexões no arquivo application.properties (caminho:src/main/resources/application.properties) que o projeto irá criar as tabelas: tb_campeonato, tb_campeonato_time, tb_estadio, tb_jogador, tb_partida, tb_resultado e tb_time. O banco irá inicializar com dados iniciais em todas as tabelas.

## Métodos Http disponíveis na API

## Campeonato
1. @GetMapping("/campeonatos")
    - Esta requisição irá retornar todos os campeonatos cadastrados.
2. @GetMapping("/campeonatos/{id}")
    - Passando o id do cameponato na requisição irá ser retornado todas as informações do campeonato solicitado.
3. @GetMapping("/campeonatos/{id}/time")
    - Passando o id do campeonato na requisição irá ser retornado todos os times do campeonato.
## Estadio
1. @GetMapping("/estadios")
    - Esta requisição irá retornar todos os estádios cadastrados.
## Jogador
1. @GetMapping("/jogadores")
    - Esta requisição irá retornar todos os jogadores cadastrados.
2. @GetMapping("/jogadores/{id}")
    - Esta requisição irá retornar somente o jogador do ID passado na busca.
## Partida
1.  @GetMapping("/partidas")
    - Esta requisição irá retornar todos as partidas cadastradas.
2. @GetMapping("/partidas/concluidas")
    - Esta requisição irá retornar todas partidas que já foram concluídas, ou seja, que já possuem resultado.
3. @GetMapping("/partidas/pendentes")
    - Esta requisição irá retornar todas partidas que ainda não foram concluídas, ou seja, ainda não possuem resultado.
## Resultado
1. @GetMapping("/resultados")
    - Esta requisição irá retornar todos os resultados das partidas.
## Time
1. @GetMapping("/times")
    - Esta Requisição irá retornar todos os times cadastrados.
2. @GetMapping("/times/{id}")
    - Esta Requisição irá retornar as informações somente do time do ID enviado.

