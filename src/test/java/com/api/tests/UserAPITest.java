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

    @Test(description = "Pattern Practice")
    public void patternPractice(){
        int num = 5;

        for(int i=1;i<=num;i++)
        {
            String s = "";
            for(int j=1;j<=i;j++){

                s= s + " " +j;
                System.out.println(s);

            }
            //System.out.println(i);
        }
    }

    @Test(description = "Pattern Practice part 1")
    public void patternPractice1(){
        int i, j, n;
        n=5;
        for(i=0; i<n; i++){  //0, 1, 2, 3, 4
            for(j=0; j<i; j++) { //0,0,1,0,1,2,0,1,2,3,0,1,2,3,4
                System.out.print("*");
            }
            System.out.println();
        }

    }

    @Test(description = "Pattern Practice part 2")
    public void patternPractice2(){
        int i, j, n;
        n=5;
        for(i=0; i<n; i++){  //1,2,3,
            for(j=4; j>i-1; j--) { //0,1,2,3,4,0,1,2,3,0,1,2,0,1
                System.out.print("*");
            }
            System.out.println();
        }

    }

    @Test(description = "Pattern Practice part 3")
    public void patternPractice3(){
        int i, j, k ,n;
        n=5;
        for(i=0; i<n; i++){  //
            for(j=4; j>i-1; j--) { //
                System.out.print("*"+" ");
            }
            System.out.println();
            for(k=-1; k<i; k++) {
                System.out.print(" ");
            }
        }

    }

    @Test(description = "Pattern Practice part 4")
    public void patternPractice4(){
        int i, j, k, n;
        n=5;

        for(i=0; i<n; i++){ //number of rows

            //for leading spaces
            for(k=0; k<i; k++) {
                System.out.print(" ");
            }
            //for the values being printed in each row
            int width = n-i;
            for(j=0; j<width; j++) {   // i=1, last position =1, i=2
                if(i==0 || j==0 || j==width-1 ){
                System.out.print("*");}
                else{
                    System.out.print(" ");
                }
                // add a space after each star (to create separation)
                if (j < width - 1) {
                    System.out.print(" ");
                }
            }

            System.out.println();

        }

    }



    }
