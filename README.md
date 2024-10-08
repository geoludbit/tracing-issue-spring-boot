# Tracing Issue Spring Boot

1. Start the application
2. run `curl -X PUT http://localhost:8080/test -H "Content-Type: application/x-www-form-urlencoded"  --data "  %@ "`
3. inspecet the logs, you will see a log statement without trace id:

```
2024-10-08T13:08:15.510+02:00 ERROR 7602 --- [nio-8080-exec-4] [demo3,,] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception

java.lang.IllegalArgumentException: URLDecoder: Incomplete trailing escape (%) pattern
	at java.base/java.net.URLDecoder.decode(URLDecoder.java:236) ~[na:na]
	at org.springframework.http.converter.FormHttpMessageConverter.read(FormHttpMessageConverter.java:351) ~[spring-web-6.1.13.jar:6.1.13]
	at org.springframework.web.filter.FormContentFilter.parseIfNecessary(FormContentFilter.java:109) ~[spring-web-6.1.13.jar:6.1.13]
	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:88) ~[spring-web-6.1.13.jar:6.1.13]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[spring-web-6.1.13.jar:6.1.13]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.springframework.web.filter.ServerHttpObservationFilter.doFilterInternal(ServerHttpObservationFilter.java:113) ~[spring-web-6.1.13.jar:6.1.13]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[spring-web-6.1.13.jar:6.1.13]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201) ~[spring-web-6.1.13.jar:6.1.13]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[spring-web-6.1.13.jar:6.1.13]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:167) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:90) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:483) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:115) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:93) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:344) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:384) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:63) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:905) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1741) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1190) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:63) ~[tomcat-embed-core-10.1.30.jar:10.1.30]
	at java.base/java.lang.Thread.run(Thread.java:1583) ~[na:na]

```