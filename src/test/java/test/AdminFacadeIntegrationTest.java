//package test;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//import static io.restassured.RestAssured.given;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
///**
// *
// * @author LouiseB
// */
//public class AdminFacadeIntegrationTest
//{
//
//    public AdminFacadeIntegrationTest()
//    {
//    }
//
//    @BeforeClass
//    public static void setUpClass()
//    {
//
//    }
//
//    @AfterClass
//    public static void tearDownClass()
//    {
//    }
//
//    @Before
//    public void setUp()
//    {
//    }
//
//    @After
//    public void tearDown()
//    {
//    }
//
//    @Test
//    public void webPageIsRunning()
//    {
//        given().when().get("http://localhost:8080/ca3").then().statusCode(200);
//    }
//
//    @Test
//    public void webPageIsNOTRunning()
//    {
//        given().when().get("http://localhost:8080/ca3/halloWorld").then().statusCode(404);
//
//    }
//
//    @Test
//    public void getUserTest()
//    {
//        given().when().get("http://localhost:8080/ca3/api/admin/users").then().statusCode(200);
////                .body("message",equalTo("user"));
//    }
//}
