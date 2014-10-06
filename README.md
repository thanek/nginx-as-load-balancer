# Nginx as simple load balancer

You can use Nginx' upstream functionality to get a light and simple load balancer.
See http://nginx.org/en/docs/http/ngx_http_upstream_module.html for more details.

This project includes simple Http server that will help you test the Nginx configuration.

## Run backend web-servers

```bash
mvn package
java -jar target/WebServer-1.0-SNAPSHOT.jar 8000 Hello&
java -jar target/WebServer-1.0-SNAPSHOT.jar 8001 World&
java -jar target/WebServer-1.0-SNAPSHOT.jar 8002 Foo&
java -jar target/WebServer-1.0-SNAPSHOT.jar 8003 Bar&
```

## Configure NGINX

```bash
sudo ln -s nginx/sites-available/backend /path/to/your/nginx/sites-enabled
sudo service nginx restart
```

## Make some requests

```bash
curl localhost:8080
```

You can also test the failover mechanisms provided by Nginx by shutting down some of your WebServer instances and see 
how the load balancing works. 
