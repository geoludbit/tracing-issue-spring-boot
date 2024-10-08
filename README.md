# Tracing Issue Spring Boot

1. Start the application
2. run `curl -X PUT http://localhost:8080/test -H "Content-Type: application/x-www-form-urlencoded"  --data "  %@ "`
3. inspecet the logs, you will see 2 log statements. first with traceid and the error without:

```
2024-10-08T13:05:27.414+02:00  INFO 7602 --- [nio-8080-exec-1] [demo3,670511f7230b63fd0e5bdb6b6331cd9e,0e5bdb6b6331cd9e] com.example.demo3.Demo3Application       : home() has been called
2024-10-08T13:08:15.510+02:00 ERROR 7602 --- [nio-8080-exec-4] [demo3,,] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception
```