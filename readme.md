# Route Service

Route Service je zaledna mikrostoritev, namenjena upravljanju in izračunu poti (routes).
Implementirana je v Spring Boot in uporablja PostgreSQL (PostGIS) podatkovno bazo.

## Tehnologije
- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL + PostGIS
- Hibernate Spatial
- Maven

## Funkcionalnost
- ustvarjanje poti (route)
- matching poti glede na razdaljo od začetne in končne točke
- pridobivanje vseh poti

## Konfiguracija
Route Service uporablja okoljske spremenljivke za povezavo do baze:

SPRING_DATASOURCE_URL  
SPRING_DATASOURCE_USERNAME  
SPRING_DATASOURCE_PASSWORD

Primer:
jdbc:postgresql://localhost:5432/routes

## Zagon lokalno

```
mvn clean package
java -jar target/route-service-0.0.1-SNAPSHOT.jar
```

Storitev teče na:
http://localhost:8080

## Swagger dokumentacija
Swagger (OpenAPI) dokumentacija je na voljo na:
http://localhost:8080/swagger-ui/index.html

## Opombe
- Storitev pričakuje, da je PostgreSQL baza že inicializirana
- PostGIS razširitev mora biti omogočena v bazi