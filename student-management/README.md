# Online Student Management System (Spring + Hibernate)

## Run

```bash
mvn -q -DskipTests exec:java
```

## Switch to MySQL

Change AppConfig.dataSource to MySQL:

```java
DriverManagerDataSource ds = new DriverManagerDataSource();
ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
ds.setUrl("jdbc:mysql://localhost:3306/smsdb?useSSL=false&serverTimezone=UTC");
ds.setUsername("root");
ds.setPassword("password");
```

And in sessionFactory properties set:

```java
props.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
props.put("hibernate.hbm2ddl.auto","update");
```

Create database `smsdb` before running.
