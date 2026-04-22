Sistema de Gerenciamento de Extensão - Etapa 1
===============================================

Disciplina: Linguagem de Programação II
Professor: Geraldo Braz Junior
Equipe: Augusto Jose Santos Nascimento
Data da Entrega: 22/04/2026

Visão Geral
-----------
Este repositório contém a Etapa 1 do trabalho prático da disciplina. O objetivo é implementar a base do sistema de gerenciamento de extensão para alunos de Ciência da Computação da UFMA, utilizando Java básico com estrutura de pacotes, classes, atributos, métodos e um teste simples.

A modelagem original foi desenvolvida por alunos do Laboratório de Engenharia de Software (Rodrigo, Therlyson e João Marcelo). Esta implementação segue as classes identificadas nos diagramas, com adaptações para aplicar conceitos de orientação a objetos desde o início.

Estrutura do Projeto
--------------------
br.ufma.lp2.sistemaextensao/
├── enums/
│   ├── Modalidade.java
│   ├── StatusAssinatura.java
│   ├── StatusGrupo.java
│   ├── StatusOportunidade.java
│   └── TipoOportunidade.java
├── entidades/
│   ├── Usuario.java          # classe base
│   ├── Discente.java         # herda de Usuario
│   ├── Docente.java          # herda de Usuario
│   ├── Oportunidade.java
│   ├── Certificado.java
│   ├── Aproveitamento.java
│   ├── Grupo.java
│   └── Documento.java
└── testes/
    └── teste.java

Classes implementadas: todas as entidades principais do diagrama, com atributos privados, construtores, getters/setters e métodos (stubs) conforme especificação.

Decisão de projeto: optou-se por herança (Discente e Docente estendem Usuario) em vez de um enum Papel, para melhor expressar os papéis e facilitar a evolução para polimorfismo na etapa 2. O enum Papel foi removido por redundância.

Pré-requisitos
--------------
- Java Development Kit (JDK) versão 21 ou superior.
- Terminal (Linux, macOS, WSL) ou Prompt de Comando (Windows).
- Git (opcional, para clonar o repositório).

Instruções de Execução
----------------------

Compilação:
Navegue até o diretório raiz do projeto (onde está a pasta br/ufma/lp2/sistemaextensao/). Compile todos os arquivos .java com:

javac -d . br/ufma/lp2/sistemaextensao/entidades/*.java br/ufma/lp2/sistemaextensao/enums/*.java br/ufma/lp2/sistemaextensao/testes/*.java

Nota: O comando acima assume que você está no diretório que contém a estrutura de pacotes. Caso use uma IDE (Eclipse, IntelliJ), basta importar o projeto e executar a classe de teste.

Execução do Teste Básico:
Após compilar, execute a classe TesteBasico:

java br.ufma.lp2.sistemaextensao.testes.TesteBasico

Saída esperada (exemplo):
Aluno: Augusto
Professor: Maria
Oportunidade publicada.
Status da oportunidade: PUBLICADA
QR Code: QRCode_simulado_hash123
Hash válido: true
Arquivo meu_certificado.pdf enviado.
Teste concluído.


Instruções de Teste
-------------------
O teste básico (TesteBasico) verifica:
- Criação de objetos Discente, Docente, Oportunidade, Certificado, Aproveitamento.

Para validar a implementação, basta executar o teste conforme acima. Caso deseje testar outras combinações, você pode criar novos cenários dentro da mesma classe ou em uma classe separada.

Uso de Ferramentas de IA Generativa (IAG)
-----------------------------------------
Em conformidade com as diretrizes da disciplina, o uso de IAG foi aplicado de forma responsável:

- Entendimento e estrutura inicial: A primeira versão da organização das classes e pacotes foi desenvolvida a partir da análise pessoal dos diagramas e da discussão com colegas.
- Refinamento e correção: A IAG (Deepseek) foi utilizada para:
   * Sugerir melhorias na clareza do código (nomes de métodos, organização de getters/setters).
   * Revisar a sintaxe e corrigir pequenos erros (ex: construtores de subclasses).
   * Explicar conceitos como herança e remoção do enum Papel para solidificar o aprendizado.
- Verificação de fatos: Todo o código gerado foi revisado manualmente, testado e comparado com a modelagem original para garantir conformidade.

Nenhum trecho de código foi copiado cegamente; a IAG serviu como assistente de aprendizado e otimização.

Branch de Entrega
-----------------
A versão correspondente a esta etapa está na branch:

etapa-1-final

Esta branch foi criada a partir da main e não receberá mais commits após a submissão no SIGAA, conforme a política de imutabilidade.

Próximos Passos (Etapa 2)
-------------------------
A etapa 2 evoluirá este código para incluir:
- Polimorfismo (ex: lista de Usuario contendo Discente e Docente).
- Abstração (transformar Usuario em classe abstrata).
- Interface de terminal (menus interativos com Scanner).
- Serviços com listas em memória para gerenciar oportunidades, inscrições, certificados.

O código atual foi projetado para ser facilmente estendido sem grandes refatorações.

Referências
-----------
- Modelagem original fornecida pelo professor (diagramas de classes e casos de uso).
- Documentação oficial do Java: https://docs.oracle.com/en/java/

Contato
-------
Dúvidas sobre o projeto podem ser tiradas no Slack da disciplina (lp2ufma) ou diretamente com o professor.

Última atualização: 22/04/2026