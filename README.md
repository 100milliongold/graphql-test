# graphql-test
graphql + Spring boot 연동예제

## 실행방법

1. docker container 생성

``` shell
docker run -d \
--name spring-jpa-test \
-e MYSQL_ROOT_PASSWORD=root \
-e MYSQL_DATABASE=db_example \
-e MYSQL_USER=springuser \
-e MYSQL_PASSWORD=ThePassword \
-p 3306:3306 \
mariadb:latest \
--character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
```

2. spring project 실행

3. generatedata.sql input
```
cat generatedata.sql | docker exec -i  spring-jpa-test /usr/bin/mysql -u root --password=root db_example
```
