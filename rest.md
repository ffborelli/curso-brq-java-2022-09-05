

# API

Application Programming Interface

# Json é chave : valor

"nome" : "Fabrizio",
"sobrenome": "Borelli",
"idade": 34

# Estrutura Json

{} -> é um objeto
[] -> é um array

# Todo Json começa com {} ou  []

{
  "curso" : "Java",
  "professor" : "Nelson", 
  "carga-horaria" : 296,
  "telefones" : [
      "11982733817", "1144833839"
  ]
}


# Sobre REST, temos os seguintes verbos:

Verbos são ações que gostaríamos de "fazer"

- GET : para "retornar" dados
- POST : para "enviar" dados novos
- PATCH : Para atualizar dados
- PUT : Para atualizar dados
- DELETE : Para deletar dados

PUT é usado quando enviamos um objeto completo. Se você quiser atualizar só uma parte dele e não reenviar tudo, use PATCH