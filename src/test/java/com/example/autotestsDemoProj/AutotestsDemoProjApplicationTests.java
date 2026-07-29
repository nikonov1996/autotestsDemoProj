package com.example.autotestsDemoProj;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class AutotestsDemoProjApplicationTests {


    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://randomuser.me";
    }

    @Test
    public void contextLoads() {
       given()
                .header("Content-Type", "application/json")
                .when()
                .get("/api/")
                .then()
                .statusCode(200);
    }

}
