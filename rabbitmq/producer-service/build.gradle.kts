plugins {
    java
    id("org.springframework.boot") version "3.3.0"
    id("io.spring.dependency-management") version "1.1.5"
}

group = "com.prosoft"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

/** Для RabbitMQ в Spring есть стартер spring-boot-starter-amqp, поэтому spring-boot-starter можно исключить */
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-amqp")
    implementation("javax.annotation:javax.annotation-api:1.3.2")
    implementation("org.apache.logging.log4j:log4j-api:2.24.0")
    implementation("org.apache.logging.log4j:log4j-core:2.24.0")
}

tasks.test {
    useJUnitPlatform()
}