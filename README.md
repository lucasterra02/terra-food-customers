# terra-food-customers - Projeto exemplificando um CRUD utilizando API Rest com Kotlin

### Stack: JDK11, Kotlin, Spring 2.6.2, MySQL, Gradle

- Banco de Dados: Deverá ter um banco MySQL rodando, ao dar o start da aplicação será criado o schema ```terra-food```

- Start da aplicação: Spring Boot, classe de inicialização: ```TerraFoodCustomersApplication```

#### Para requisição nos recursos das APIs seguir os passos:

1 - Realizar um cadastro de Customer:

```POST``` em: `localhost:8080/customers`
```
    {
      "name": "Lucas",
      "email": "lucas@teste.com",
      "password": "123456"
    }
```
2 - Realizar Login com usuário criado:

```POST``` em: `localhost:8080/login`
```    
    {
      "email": "lucas@teste.com",
      "password": "123456"
    }
```
2.1 - Será gerado um `Bearer token` no Header de Resposta
      utilizar este token para chamar os recursos autenticados:
          
 - Exemplo de CURL, passando Authorization com token:
```
          curl --location --request GET 'localhost:8080/customers' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUdas124iOiIxMSIsImVasMTY0MzE1MDk5Mn0.YiEpEiT3D2kZgp6Xs_EjOaJBvOk-8XFAnXmnvA_XAvQl0TDXc1Oaas4DfinPKNdxMs123G97vSDFWUVAw97tw'
```

3 - Outros recursos:

```
GET localhost:8080/customers
```
```
GET localhost:8080/customer?name=Lucas
```
```
GET localhost:8080/customers/10
```
```
PUT localhost:8080/customer/1

{
    "name": "ad",
    "email": "lucas@emaisssl.com"
}
```
```
DELETE localhost:8080/customer/22
```
```
GET localhost:8080/product?size=50&page=0
```
```
GET localhost:8080/product/22
```
```
POST localhost:8080/product

{
    "name": "Abobora",
    "price": 15.00,
    "customer_id": 3
}
```
```
PUT localhost:8080/product/1

{
    "name": "teste teste",
    "price": 22.00
}
```
```
DELETE localhost:8080/product/22
```
```
POST localhost:8080/purchase

{
    "customer_id": 3,
    "product_ids": [4,2]
}
```
