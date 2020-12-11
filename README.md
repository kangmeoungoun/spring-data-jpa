1부: 핵심 개념 이해
본격적인 스프링 데이터 JPA 활용법을 학습하기에 앞서, ORM과 JPA에 대한 이론적인 배경을 학습합니다. 

관계형 데이터베이스와 자바

JDBC
(관계형) 데이터베이스와 자바의 연결 고리

JDBC
DataSource / DriverManager
Connection
PreparedStatement

SQL
DDL
DML

무엇이 문제인가?
SQL을 실행하는 비용이 비싸다.
SQL이 데이터베이스 마다 다르다.
스키마를 바꿨더니 코드가 너무 많이 바뀌네...
반복적인 코드가 너무 많아.
당장은 필요가 없는데 언제 쓸 줄 모르니까 미리 다 읽어와야 하나...

의존성 추가

<dependency>
   <groupId>org.postgresql</groupId>
   <artifactId>postgresql</artifactId>
</dependency>

PostgreSQL 설치 및 서버 실행 (docker)

docker run -p 5432:5432 -e POSTGRES_PASSWORD=pass -e POSTGRES_USER=keesun -e POSTGRES_DB=springdata --name postgres_boot -d postgres

docker exec -i -t postgres_boot bash

su - postgres

psql springdata

데이터베이스 조회
\list

테이블 조회
\dt

쿼리
SELECT * FROM account;

