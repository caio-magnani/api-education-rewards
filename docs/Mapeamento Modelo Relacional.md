# Mapeamento Modelo Relacional
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

[back](../README.md)