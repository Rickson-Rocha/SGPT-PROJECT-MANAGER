# SGPT-PROJECT-MANAGER (BACK END)

![Status](https://img.shields.io/badge/status-em%20desenvolvimento-orange)

## **Sistema de Gerenciamento de Projetos e Tarefas (SGPT)**

O **SGPT** é um sistema corporativo projetado para facilitar o gerenciamento de projetos e tarefas em equipes de desenvolvimento de software ou em ambientes corporativos em geral. O sistema permite a criação de projetos, atribuição de tarefas a membros da equipe, acompanhamento do progresso e análise de produtividade. Os usuários terão diferentes níveis de acesso, e notificações são enviadas para manter todos atualizados.

---

## **Objetivos do Projeto**

1. **Gerenciar projetos e tarefas**: Criar e gerenciar projetos e tarefas com prazos, responsáveis e status.
2. **Colaboração em tempo real**: Permitir atualizações sincronizadas no progresso das tarefas.
3. **Integração com mensageria**: Usar RabbitMQ para notificações e atualizações em tempo real.
5. **Persistência de dados**: Utilizar PostgreSQL  para armazenar informações.
6. **Autenticação e controle de acesso**: Implementar permissões para diferentes níveis de usuários.

---

## **Tecnologias Utilizadas**

### **Backend**
- ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-%236DB33F?style=for-the-badge&logo=spring&logoColor=white)
- ![RabbitMQ](https://img.shields.io/badge/RabbitMQ-%23FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white)
- ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-%23336791?style=for-the-badge&logo=postgresql&logoColor=white)
- ![Spring Security](https://img.shields.io/badge/Spring%20Security-%236DB33F?style=for-the-badge&logo=spring&logoColor=white)
- ![Docker](https://img.shields.io/badge/Docker-%232496ED?style=for-the-badge&logo=docker&logoColor=white)

### **Mensageria e Notificações**
- ![RabbitMQ](https://img.shields.io/badge/RabbitMQ-%23FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white)

### **Autenticação**
- ![JWT](https://img.shields.io/badge/JWT-%23000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white)

### **Outras Tecnologias**
- ![Swagger](https://img.shields.io/badge/Swagger-%2365B844?style=for-the-badge&logo=swagger&logoColor=white)
- ![JUnit](https://img.shields.io/badge/JUnit-%2325A162?style=for-the-badge&logo=junit5&logoColor=white)
- ![Mockito](https://img.shields.io/badge/Mockito-%234072B3?style=for-the-badge)

---

## **Funcionalidades do Sistema**

### 1. **Gerenciamento de Projetos e Tarefas**
- Criação e edição de projetos com nome, descrição e prazo.
- Criação e atribuição de tarefas com título, descrição, prioridade, prazo e responsável.
- Alteração de status das tarefas: **"A Fazer"**, **"Em Progresso"**, **"Concluído"**.
- Monitoramento de progresso de projetos com gráficos de produtividade.

### 2. **Autenticação e Controle de Acesso**
- Login seguro com **JWT**.
- Níveis de acesso: **Administrador**, **Gerente**, e **Colaborador**.
- Controle de ações com base no papel do usuário.

### 3. **Colaboração e Notificações**
- Atualizações em tempo real de progresso usando **WebSockets**.
- Notificações via **RabbitMQ** para eventos importantes.
- Histórico de alterações rastreando atividades.

### 4. **Relatórios e Análise**
- Geração de relatórios de produtividade.
- Exportação de relatórios em **PDF** ou **Excel**.
- Gráficos e tabelas para análise do histórico de tarefas e prazos.

---




