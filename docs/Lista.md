# Back-End
## Login - Aluno, Professor, Parceiros, Instituition
## Aluno - CRUD
## Professor - CRUD
## Depositos
## Parceiros - R, U
## Instituição - R, U
## Suporte - C ou D de Parceirtos e Instituição
## Instituição - desativar Professor

---

# Front-End

##  Login - [ ]
### Requisição ao back-end

POST localhost:8080/user/login

```json
{
    "email":"email",
    "senha":"senha"
}
```

### Retorno do back-end

```json
{
    "id": 3,
    "name": "caio",
    "email": "exemplo@student.com",
    "password": "senha",
    "type": "Student",
    "cpf": "123.123.233-11",
    "bank": {
        "coins": 0.0
    }
}
```

---

## Tele de Update e Delete Usuário
### Requisição ao back-end

POST localhost:8080/student/update
POST localhost:8080/instituition/update
POST localhost:8080/teacher/update

POST localhost:8080/partner/update
```json
{
    "id":4, -> Importante ser o mesmo id
    "name": "partner update", -> não pode ter campos nulos
    "email": "exemplo@partner.com",
    "password": "senha",
    "cnpj": "123.123.233-00"
}
```
GET localhost:8080/user/delete/id

---

## Tela de Aluno

---

## Área de Compra
### Requisição ao back-end

POST - localhost:8080/offer

```json
{
    "idUser":"1",
    "ofertasId":["1","2","3",...]
}
```

## Área de Extrato - Professor, Aluno

### Requisição ao back-end

GET localhost:8080/records/id

---

## Tela de Professor

---

## Área de Transferencia
### Requisição ao back-end
```json
{
    "toId":1,
    "fromId":1,
    "howMuch":50.90
}
```

---

