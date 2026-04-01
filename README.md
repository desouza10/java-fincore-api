# 🚀 Fincore API

API REST construída com Spring Boot para gerenciamento de transações financeiras.

Este projeto foi desenvolvido com foco em entender os fundamentos do ecossistema Spring, indo além do uso direto do Spring Boot e explorando conceitos como arquitetura em camadas, injeção de dependência e tratamento global de exceções.

---

## 🧠 Objetivo

Explorar a construção de uma API backend em Java aplicando boas práticas de arquitetura e organização de código, simulando um cenário real de mercado.

---

## 🏗️ Arquitetura

O projeto segue uma estrutura em camadas:

```
com.gui.fincore
├── controller     # Camada de entrada (HTTP)
├── service        # Regras de negócio
├── model          # Entidades do domínio
├── enums          # Tipos fixos (status, tipo de transação)
└── exception      # Tratamento global de erros
```

---

## ⚙️ Tecnologias

- Java 21
- Spring Boot
- Gradle
- Lombok

---

## 🔥 Funcionalidades

### 📌 Listar transações
```
GET /transactions
```

### 📌 Buscar transação por ID
```
GET /transactions/{id}
```

---

## ⚠️ Tratamento de Erros

A API possui tratamento global de exceções, retornando respostas padronizadas:

```json
{
  "timestamp": "2026-03-31T00:24:01",
  "status": 404,
  "error": "Not Found",
  "message": "Transaction not found",
  "path": "/transactions/66"
}
```

---

## 🧪 Testes

Os endpoints podem ser testados utilizando:

- Insomnia
- Postman
- Navegador (para requisições GET)

---

## 💡 Boas práticas aplicadas

- Uso de `BigDecimal` para valores monetários
- Uso de `enum` para domínio (TransactionType, TransactionStatus)
- Separação de responsabilidades por camada
- Tratamento global de exceções (`@RestControllerAdvice`)
- Imutabilidade em objetos de resposta

---

## 🚀 Próximos passos

- [x] Implementar criação de transações (POST)
- [ ] Implementar atualização (PUT)
- [ ] Implementar remoção (DELETE)
- [ ] Integração com banco de dados (JPA)
- [ ] Validação de dados

---

## 👨‍💻 Autor

Guilherme Souza  
Engenheiro Front-End explorando o ecossistema backend com Java ☕

---

## 📌 Observação

Este projeto tem caráter educacional e evolutivo, sendo constantemente aprimorado conforme novos conceitos são estudados.
