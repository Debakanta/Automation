package com.definations;
import io.cucumber.java.BeforeAll;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.actions.Mapper;

import com.utils.HelperClassPayload;
import com.utils.User;
import io.restassured.RestAssured;

import io.restassured.response.Response;

import java.io.FileReader;
import java.io.IOException;

import java.util.Properties;
import org.testng.Assert;
 
public class UserCreation {
	
	ObjectMapper objectMappeer;
	User user;
	Response response=null;
	Mapper mapper;
	static Properties p;
	FileReader reader;
	
	
	
    @BeforeAll
    public static void setup() throws IOException {
    	FileReader reader=new FileReader("testdata.properties");  
        
        p=new Properties();  
        p.load(reader);  
    	
    	p.load(reader);
        RestAssured.baseURI =p.getProperty("endpoint") ;
        

    }        
    
    @When("User calls users api with post http request")
    public void postCall() {

        		response = RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .body(HelperClassPayload.body(p.getProperty("name"),p.getProperty("job")))
                .when()
                .post(p.getProperty("path"))
                .then()
                .extract().response();
        		
        		
        		System.out.println(response.getBody().asString());
        		
        		mapper=new Mapper();
            	objectMappeer= mapper.getMapper(user,response.getBody().asString());
 
    }
    @Then("User should get the response code as 201")
    public void verifyresponseCode() throws JsonMappingException, JsonProcessingException {
    	
        Assert.assertEquals(response.getStatusCode(),201);
 
    }
    @Then("User should have name in resoponse")
    public void verifyName() throws JsonMappingException, JsonProcessingException {
 
    	
    	user =objectMappeer.readValue(response.getBody().asString(), User.class);
    	
        Assert.assertEquals(user.getName(),user.getName());
 
    }
    @Then("User should have job in resoponse")
    public void verifyJob() throws JsonMappingException, JsonProcessingException {
 
    	
    	user =objectMappeer.readValue(response.getBody().asString(), User.class);
    	
        Assert.assertEquals(user.getName(),user.getName());
 
    }
    @Then("User should have id in resoponse")
    public void verifyId() {
 
        Assert.assertTrue(user.getId()!=null);
 
    }
    @Then("User should have createdAt in resoponse")
    public void verifyCreatedAt() {
 
    	Assert.assertTrue(user.getCreatedAt()!=null);
 
    }
    @Then("User should not get response code otherthan 201")
    public void verifyresponseCodeNotEqals() throws JsonMappingException, JsonProcessingException {
    	
        Assert.assertNotEquals(response.getStatusCode(),200);
 
    }
    
}