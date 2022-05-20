# Diagramas

- [Caso de Uso](#diagrama-de-caso-de-uso)
- [Diagrama de Implementação](#diagrama-de-implementação)
- [Diagrama de Componentes](#diagrama-de-componentes)
- [Diagrama de Classes](#diagrama-de-classes)
- [Modelo Relacional](#modelo-relacional)
- [Diagramas de Sequência Sistema](#diagramas-de-sequência-sistema)
- [Diagramas de Sequência](#diagramas-de-sequência)
  

## Diagrama de Caso de Uso
![Diagrama de Caso de Uso](./img/Caso%20de%20Uso.png)

#### [Back](./docs.md/#diagramas)

---

## Diagrama de Implementação
![Diagrama de Implementação](./img/Diagrama%20de%20Implementa%C3%A7%C3%A3o.png)

#### [Back](./docs.md/#diagramas)

---

## Diagrama de Componentes
![Diagrama de Componentes](./img/Diagrama%20de%20Componentes.png)

#### [Back](./docs.md/#diagramas)

---

## Diagrama de Classes
![Diagrama de Classes](./img/Diagrama%20de%20Classes.png)

#### [Back](./docs.md/#diagramas)

---
## Modelo Relacional

NaturalPersonUser(@id, CPF, Wallet, [idUser](./Mapeamento%20Modelo%20Relacional.md) )

Student(@id, SSN, Address, CollegeProgram, BankAccount, [idNaturalPersonUser](./Mapeamento%20Modelo%20Relacional.md) )

Teacher(@id, department, BankAccount, [idNaturalPersonUser](./Mapeamento%20Modelo%20Relacional.md) )

User(@id, Name, Email, Password)

LegalPersonUser(@id, CNPJ, [idUser](./Mapeamento%20Modelo%20Relacional.md) , [idInstitution](./Mapeamento%20Modelo%20Relacional.md) )

Partner(@id, Name, [idOffer](./Mapeamento%20Modelo%20Relacional.md) )

Offer(@id, Name, Cost, [idCoupon](./Mapeamento%20Modelo%20Relacional.md) )

Institution(@id, Name, [idStudent](./Mapeamento%20Modelo%20Relacional.md) , [idOffer](./Mapeamento%20Modelo%20Relacional.md) )

History(@id, Name, [idBankAccount](./Mapeamento%20Modelo%20Relacional.md) )

BankAccount(@id, Coins)

#### [back](./docs.md/#diagramas)

---

## Diagramas de Sequência Sistema
### CRUD Aluno
![CRUD Aluno](./img/Diagrama%20de%20Sequencia%20Sistema/Aluno/CRUD%20Aluno.png)
#### [Back](./docs.md/#diagramas)

---

## Diagramas de Sequência
## Aluno
### A1, A2
![Diagrama de Sequência - A1, A2](./img/Diagramas%20de%20Sequencia/Aluno-A%23/A1_A2.png)
#### [Back](./docs.md/#diagramas)
---
## Cliente
### C1, C2
![Diagrama de Sequência - C1, C2](./img/Diagramas%20de%20Sequencia/Cliente-C%23/C1_C2.png)
#### [Back](./docs.md/#diagramas)
---
## Instituição
### I1
![Diagrama de Sequência - I1](./img/Diagramas%20de%20Sequencia/Institui%C3%A7%C3%A3o-I%23/I1.png)
#### [Back](./docs.md/#diagramas)
### I2
![Diagrama de Sequência - I2](./img/Diagramas%20de%20Sequencia/Institui%C3%A7%C3%A3o-I%23/I2.png)
#### [Back](./docs.md/#diagramas)
---
## Parceiro
### Pa1
![Diagrama de Sequência - Pa1](./img/Diagramas%20de%20Sequencia/Parceiro-Pa%23/Pa1.png)
#### [Back](./docs.md/#diagramas)
### Pa2, Pa3
![Diagrama de Sequência - Pa2, Pa3](./img/Diagramas%20de%20Sequencia/Parceiro-Pa%23/Pa2_Pa3.png)
#### [Back](./docs.md/#diagramas)
---
## Professor
### P1
![Diagrama de Sequência - P1](./img/Diagramas%20de%20Sequencia/Professor-P%23/P1.png)
#### [Back](./docs.md/#diagramas)
---
## Usuário
### U1
![Diagrama de Sequência - U1](./img/Diagramas%20de%20Sequencia/Usu%C3%A1rio-U%23/U1.png)
#### [Back](./docs.md/#diagramas)
### U2
![Diagrama de Sequência - U2](./img/Diagramas%20de%20Sequencia/Usu%C3%A1rio-U%23/U2.png)
#### [Back](./docs.md/#diagramas)
### U3, U4, U5
![Diagrama de Sequência - U3, U4, U5](./img/Diagramas%20de%20Sequencia/Usu%C3%A1rio-U%23/U3_U4_U5.png)
#### [Back](./docs.md/#diagramas)
---