# Agenda JSF

Este projeto simula uma agenda de contatos com as funções de CRUD implementadas com Mysql, utilizando Java ServerFaces (JSF), Hibernate e JPA, Bootstrap 4 e Primefaces, dentro do padrão MVC (Model-View-Controller).

Contempla os itens A,B,C,F,G da lista de requisitos.

O projeto foi desenvolvido para consistir em uma SPA ou Single-Page Application, inicialmente tem a opção de inserir um novo contato (com Nome, Sobrenome, Email e Telefone), e logo abaixo está a listagem dos contatos cadastrados. Nesta listagem, existem as opções de alterar um contato, onde ao clicar, as informações são redirecionadas para o mesmo formulário que o usuário realizou o cadastro, e as informações são alteradas ao clicar em salvar novamente. E também a opção de remover um contato. O datatable do ManagedBean no JSF possui a característica de data binding, ou seja, permite que todas as informações alteradas no banco, sejam alteradas na página sem que seja necessária sua atualização.

Versões das tecnologias utilizadas: 
Eclipse IDE for Enterprise Java Developers 2020-09, JDK 12.0, Xampp v3.2.4 (com Mysql), Tomcat 8.0, Primefaces 7.0
Obs: As outras tecnologias já estão configuradas no pom.xml, nas dependências do Maven, basta fazer o Update Project no Maven para que ele baixe.
