# lx.w.server

## Jetty Web Server

```bash
make
```

https://localhost:8080/mirror?key=hello

### Cервлет, обрабатывающий запросы на `/mirror`:
- При получении `GET` запроса с параметром `key=value` сервлет веращает в `response` строку содержащую `value`.

