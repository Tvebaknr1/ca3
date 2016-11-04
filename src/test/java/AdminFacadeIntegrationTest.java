///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
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
//
//
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
//    }
//    
//   
//    /**
//     * Test of getUsers method, of class AdminFacade.
//     */
////    @Test
////    public void testGetUsers()
////    {
////        System.out.println("getUsers");
////        AdminFacade instance = new AdminFacade();
////        List<User> expResult = {};
////        List<entity.User> result = instance.getUsers();
////        assertEquals(expResult, result);
////        fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of deleteuserbyid method, of class AdminFacade.
////     */
////    @Test
////    public void testDeleteuserbyid()
////    {
////        System.out.println("deleteuserbyid");
////        int i = 0;
////        AdminFacade instance = new AdminFacade();
////        instance.deleteuserbyid(i);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
//}
