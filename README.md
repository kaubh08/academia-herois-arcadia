# Academia de Heróis de Arcádia

Aplicação de console desenvolvida em Java 17 com Maven para gerenciar heróis, missões e o relatório final do reino.

## Pré-requisitos

- JDK 17 ou superior
- Maven 3.9 ou superior

## Como executar no IntelliJ IDEA

1. Selecione **File > Open** e escolha esta pasta (a que contém o arquivo `pom.xml`).
2. Confirme a abertura do projeto e aguarde a importação do Maven.
3. Execute a classe `com.arcadia.heroes.Application`.

## Como executar pelo terminal

```bash
mvn compile
java -cp target/classes com.arcadia.heroes.Application
```

## Funcionalidades

- Cadastro de até 20 heróis em um vetor (`Hero[]`).
- Listagem dos heróis cadastrados.
- Busca de herói pelo nome.
- Estatísticas gerais e relatório final do reino.
- Missões com nome, dificuldade, recompensa em ouro, início e conclusão.
- Classes de personagem: Guerreiro (`Warrior`), Mago (`Mage`) e Arqueiro (`Archer`).

## Conceitos de orientação a objetos

- Encapsulamento com atributos privados e métodos de acesso controlado.
- Abstração por meio da classe abstrata `Hero`.
- Herança: `Warrior`, `Mage` e `Archer` estendem `Hero`.
- Polimorfismo no vetor de heróis e nos métodos sobrescritos.
- Sobrescrita de `calculateStrength()` e `useSpecialAbility()` nas subclasses.
- Sobrecarga dos métodos `attack()` e `attack(Hero target)`.

## Convenções do projeto

- Pastas, pacotes e nomes técnicos estão em inglês.
- Classes usam `PascalCase`.
- Variáveis, atributos e métodos usam `camelCase`.
- O código está separado por responsabilidade nos pacotes `model`, `service` e `ui`.
