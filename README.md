# TaxiDriverService
## Описание

REST-сервис для обработки запросов водителей такси. Проверяет наличие водителя в БД, отвечает за вывод доступных заказов и изменение статуса заказа.
### Используемый стек технологий
- H2 database
- Open Feign
- Eureca Server

### Порядок запуска микросервисов такси(для разработки)

1. Zookeper и Kafka
2. taxi-eureca
3. taxi-order-service
4. taxi-order-history-service
5. taxi-customer-service
6. taxi-driver-service

# REST API
REST API приложения представлен ниже

## Вывод доступных заказов
### Запрос
`GET /api/orders`

    curl http://localhost:5557/api/orders
### Ответ
    HTTP/1.1 200 
    Content-Type: application/json
    Transfer-Encoding: chunked
    Date: Sat, 12 Nov 2021 17:01:19 GMT

    [{"id":1,"username":"Customer0","driverUsername":null,"status":"CREATED","information":"Information0"},{"id":2,"username":"Customer1","driverUsername":null,"status":"CREATED","information":"Information1"},{"id":3,"username":"Customer2","driverUsername":null,"status":"CREATED","information":"Information2"},{"id":4,"username":"Customer3","driverUsername":null,"status":"CREATED","information":"Information3"},{"id":5,"username":"Customer4","driverUsername":null,"status":"CREATED","information":"Information4"},{"id":6,"username":"Customer5","driverUsername":null,"status":"CREATED","information":"Information5"},{"id":7,"username":"Customer6","driverUsername":null,"status":"CREATED","information":"Information6"},{"id":8,"username":"Customer7","driverUsername":null,"status":"CREATED","information":"Information7"},{"id":9,"username":"Customer8","driverUsername":null,"status":"CREATED","information":"Information8"},{"id":10,"username":"Customer9","driverUsername":null,"status":"CREATED","information":"Information9"}}]%
## Обновление заказа
### Запрос
`PUT /api/orders/{id}`

    curl -i -H 'Content-Type: application/json' -d '{"username" : "Customer1", "status" : "CLOSED"}' -X PUT http://localhost:5556/api/orders/10
### Ответ
    HTTP/1.1 201 
    Content-Type: application/json
    Transfer-Encoding: chunked
    Date: Sat, 12 Nov 2021 16:08:23 GMT

    {"id":10,"username":"Customer1","driverUsername":null,"status":"CLOSED","information":null}% 

# Осталось реализовать
- контейнеризация
- liquibase\flyway
