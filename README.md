## Etapa 2 – POO e Interface Terminal

### Funcionalidades implementadas:
- Cadastro e login de usuários (Discente, Docente, Coordenador, Administrador).
- Menu interativo para cada tipo de usuário (polimorfismo).
- Discente pode:
  - Listar oportunidades abertas.
  - Inscrever-se em oportunidades (com validação de vagas e status).
- Docente pode:
  - Criar oportunidades.
  - Publicar oportunidades.
  - Encerrar oportunidades.

### Como testar:
1. Execute `SistemaTerminal`.
2. Faça login com:
   - Discente: joao@email.com / 123
   - Docente: maria@email.com / 456
3. Explore os menus.

### Conceitos POO aplicados:
- **Abstração**: classe `Usuario` abstrata com método `exibirMenu()`.
- **Herança**: `Discente`, `Docente` estendem `Usuario`.
- **Polimorfismo**: chamada de `exibirMenu()` sem saber o tipo específico.
- **Encapsulamento**: atributos privados e serviços estáticos.
