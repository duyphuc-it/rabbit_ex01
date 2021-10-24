CÓ 2 project ví dụ về sử dụng spring để thao tác với rabbitmq: publisher & consumer.
Để cài rabbitmq, dùng docker chạy lệnh:
```
docker run -d --hostname rabbitmq-hostname --rm --name test-rabbitmq -p 15672:15672 -p 5672:5672 rabbitmq:3-management
```
