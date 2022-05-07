# Laboratorio-3

## Sumário
### [Historia de Usuário](#historia-de-usuários-e-regras-de-negócio)
### [Seminário](./seminario/seminario.md/#seminário-net)
### [Diagramas](./docs/docs.md/#diagramas)
- [Caso de Uso](./docs/docs.md/#diagrama-de-caso-de-uso)
- [Implementação](./docs/docs.md/#diagrama-de-implementação)
- [Componentes](./docs/docs.md/#diagrama-de-componentes)
- [Classes](./docs/docs.md/#diagrama-de-classes)
- [Mapeamento Modelo relacional](./docs/docs.md/#modelo-relacional)
- [Sequência Sistema](./docs/docs.md/#diagramas-de-sequência-sistema)
- [Sequência](./docs/docs.md/#diagramas-de-sequência)
    - [Aluno](./docs/docs.md/#aluno)
    - [Cliente](./docs/docs.md/#cliente)
    - [Instituição](./docs/docs.md/#instituição)
    - [Parceiro](./docs/docs.md/#parceiro)
    - [Professor](./docs/docs.md/#professor)
    - [Usuário](./docs/docs.md/#|Usuário)


---

# Historia de Usuários e Regras de Negócio

## Historia de Usuários
- I1 -> Eu como Intituição gostaria de exportar .csv para cadastro de professores.
- I2 -> Eu como Intituição gostaria de destivar uma conta professor.

- U1 -> Eu como usuário gostaria de fazer cadastro.
- U2 -> Eu como Usuário gostaria de fazer login.
- U3 -> Eu como Usuário gostaria de ver a conta
- U4 -> Eu como Usuário gostaria de deletar a conta.
- U5 -> Eu como Usuário gostaria de editar as informações de conta.

- C1 -> Eu como Cliente gostaria de ver meu Saldo de moedas.
- C2 -> Eu como Cliente gostaria de ver meu historico e extrato.

- P1 -> Eu como Professor gostaria de fazer transferencias aos meus alunos.

- A1 -> Eu como Aluno gostaria de comprar Ofertas.
- A2 -> Eu como Aluno gostaria de ver Cupom.

- Pa1 -> Eu como Parceiro gostaria de criar Oferta.
- Pa2 -> Eu como Parceiro gostaria de verificar se um Cupom é válido.
- Pa3 -> Eu como Parceiro gostaria tornar Cupom invalido.

## Regras de negocio
- R1 -> Todo login deve ser autentificado.
- R2 -> A cada semestre é adicionado 1000 moedas ao saldo dos professores. 
- R3 -> Ao gerar o Cupom ele deve ser enviado ao aluno por email.

#### [Back](#sumário)