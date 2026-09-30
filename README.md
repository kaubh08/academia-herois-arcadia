# Academia de Heróis de Arcádia

> Um sistema de console para organizar os heróis que protegem o Reino de Arcádia.

O reino está sob ameaça e a Academia precisa registrar seus novos heróis, acompanhar suas missões e gerar um relatório sobre quem está preparado para defender a população. Este projeto foi desenvolvido para a Atividade 1 de Orientação a Objetos, usando Java 17 e Maven.

Mais do que cadastrar dados, a aplicação foi pensada para exercitar conceitos fundamentais de programação orientada a objetos de forma simples: cada herói possui características próprias, pode receber uma missão e contribui para o relatório final do reino.

## O que o sistema permite fazer

- Cadastrar até 20 heróis em um vetor (`Hero[]`).
- Escolher entre as classes Guerreiro, Mago e Arqueiro.
- Listar todos os heróis cadastrados e consultar seus atributos.
- Buscar um herói pelo nome.
- Iniciar e concluir missões com dificuldade e recompensa em ouro.
- Consultar estatísticas gerais da academia.
- Exibir, ao encerrar, o relatório final do Reino de Arcádia.

As mensagens exibidas no menu estão em português. Os nomes técnicos de classes, pacotes e pastas permanecem em inglês, seguindo a convenção adotada no projeto.

## Estrutura do projeto

```text
src/main/java/com/arcadia/heroes
├── Application.java       # ponto de entrada da aplicação
├── model                  # classes que representam os dados do domínio
│   ├── Hero.java
│   ├── Warrior.java
│   ├── Mage.java
│   ├── Archer.java
│   └── Mission.java
├── service
│   └── HeroAcademy.java   # regras de cadastro, missões e relatórios
└── ui
    └── ConsoleMenu.java   # interação com a pessoa usuária
```

## Pré-requisitos

- JDK 17 ou superior.
- Maven 3.9 ou superior.

## Como executar no IntelliJ IDEA

1. Escolha **File > Open** e selecione a pasta que contém o arquivo `pom.xml`.
2. Confirme a abertura do projeto e aguarde o IntelliJ importar o Maven.
3. Abra `src/main/java/com/arcadia/heroes/Application.java`.
4. Clique no ícone verde ▶ ao lado do método `main`.
5. Use o painel **Run** para escolher as opções do menu.

## Como executar pelo terminal

```bash
mvn compile
java -cp target/classes com.arcadia.heroes.Application
```

## Exemplo de uso

Ao executar o programa, escolha `1` para cadastrar um herói. Depois informe os dados solicitados, como nome, nível, vida, mana e os atributos da classe escolhida. Para registrar uma missão, escolha a opção `5`; para concluí-la, use a opção `6`. A opção `4` mostra as estatísticas e a opção `0` encerra o programa exibindo o relatório final.

## Conceitos de orientação a objetos aplicados

| Conceito | Como aparece no projeto |
| --- | --- |
| Encapsulamento | Os atributos são privados e acessados por métodos controlados. |
| Abstração | `Hero` é uma classe abstrata que representa o que todos os heróis têm em comum. |
| Herança | `Warrior`, `Mage` e `Archer` herdam de `Hero`. |
| Polimorfismo | O vetor `Hero[]` armazena heróis de diferentes classes e chama seus comportamentos específicos. |
| Sobrescrita | Cada classe calcula sua força e executa sua habilidade especial de uma forma própria. |
| Sobrecarga | Os métodos `attack()` e `attack(Hero target)` possuem o mesmo nome, mas parâmetros diferentes. |

## Convenções e boas práticas

- Classes usam `PascalCase`; atributos, variáveis e métodos usam `camelCase`.
- Pacotes e nomes técnicos estão em inglês, mantendo uma organização consistente.
- As responsabilidades foram separadas entre `model`, `service` e `ui`.
- Entradas numéricas e campos obrigatórios são validados no menu.
- Há comentários em português nos pontos em que a regra de negócio ou o conceito de OO precisa de explicação.
