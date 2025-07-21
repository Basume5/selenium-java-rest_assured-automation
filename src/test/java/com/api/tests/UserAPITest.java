package com.api.tests;

import com.api.base.AuthService;
import com.api.model.LoginRequest.LoginRequest;
import com.api.model.LoginResponse.LoginResponse;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;

@Epic("Login Feature")
@Feature("Valid Login")

public class UserAPITest {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Login with valid user and password")
    @Test
    public void testGetUsers(){
        RestAssured.baseURI = "https://reqres.in";

        given()
                .queryParam("page", 2)
                .header("x-api-key","reqres-free-v1")
                .when()
                .get("/api/users")
                .then()
                .statusCode(200).log().body()
                .header("Content-Type","application/json; charset=utf-8");


    }

    @Test(description = "Verify if login API is working")
    public void loginTest(){
        RestAssured.baseURI = "http://64.227.160.186:8080";
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body("{\"username\": \"uday1234\", \"password\": \"uday1234\"}")
                .post("/api/auth/login");
        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 401);
    }


    @Test(description = "Verify if login API is working_Using wrapper around rest assured")
    public void loginTest1(){

        LoginRequest loginRequest = new LoginRequest("uday1234","uday1234");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        System.out.println(response.asPrettyString());
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(loginResponse.getStatus());

    }


    }
