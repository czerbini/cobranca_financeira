# 🚀 Sistema de Cobrança Financeira Automatizada

Aplicação backend desenvolvida em **Java com Spring Boot** para gestão e automação do envio de faturas, contemplando cenários de cobrança e comunicação com clientes.

O sistema realiza o controle do ciclo de faturamento, desde a criação até o envio de notificações automáticas de vencimento e segunda via por e-mail.

---

## 💡 Funcionalidades

- 📄 Criação de faturas vinculadas a clientes
- 🔍 Consulta de faturas por CPF
- ⏰ Envio de lembretes de vencimento em D-1
- ⚠️ Notificação automática de faturas vencidas
- 📩 Envio de segunda via de fatura
- 🔄 Atualização automática de status da fatura

---

## 🧠 Regras de Negócio

- Validação de cliente via CPF antes da criação da fatura
- Processamento automático baseado em data (`LocalDate`)
- Tratamento de cenários de pré-vencimento e pós-vencimento

---

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web (REST APIs)
- Spring Data JPA (Hibernate)
- MySQL
- Lombok
- Jakarta Validation
- Maven

---

## 🧩 Arquitetura

O projeto segue uma estrutura organizada em camadas:

src/main/java/com/carolina/projeto_cobranca_financeira  
├── controller  
├── service  
├── repository  
├── model  
├── dto  
└── enums  


---

## 🔥 Destaques Técnicos

- Relacionamento bidirecional entre entidades (Cliente ↔ Fatura)
- Controle de serialização JSON
- Validações robustas com Bean Validation
- Automação de envio de comunicações baseada em regras de negócio
- Implementação de agendamentos automáticos (`@Scheduled`)

---

## 📈 Melhorias Futuras

- Dashboard de monitoramento de cobranças

---

## 👩‍💻 Sobre o Projeto

Este projeto foi desenvolvido com objetivo de simular um cenário real de mercado, aplicando boas práticas de desenvolvimento backend com Java e Spring Boot, incluindo persistência de dados, regras de negócio e automação de processos.

---
