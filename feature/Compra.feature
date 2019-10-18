# language: pt
# charset: UTF-8

Funcionalidade: Compra
  Eu como cliente da loja gostaria de realizar a compra de qualquer produto disponível.

   Cenario: CT001 - AP - Realizar uma compra com sucesso
    Dado eu estou na pagina incial
    Quando eu adicionar um produto no carrinho
     |PRODUTO|
     |Blouse |
     E realizo o cadastro do cliente
     E confirma endereco de recebimento
     E aceita termo da Ordem de Servico
     E seleciono o metodo de pagamento
     |METODO_PAGAMENTO|
     |Pay by bank wire|
     E confirmo a compra
    Entao valido se a compra foi realizada com sucesso