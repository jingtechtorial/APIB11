package get;

import groovy.json.JsonOutput;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cat {
    @Test
    public void cat(){

        Response response= RestAssured.given().header("Accept","application/json")
                .when()//click send
                .get("https://cat-fact.herokuapp.com/facts")//click send
                .then().statusCode(200).extract().response();
       List<Map<String,Object>> cateFctList=response.as(new TypeRef<List<Map<String, Object>>>() {

       });
       for(int i=0;i<cateFctList.size();i++){
           Map<String, Object> catfact= cateFctList.get(i);
           System.out.println(catfact);


       }





    }
    @Test
    public void catfactlast(){

        Response response= RestAssured.given().header("Accept","application/json")
                .when()//click send
                .get("https://cat-fact.herokuapp.com/facts")//click send
                .then().statusCode(200).extract().response();
        List<Map<String,Object>> parsedResponse=response.as(new TypeRef<List<Map<String, Object>>>() {
        });
        Map<String, Object> lastfact = parsedResponse.get(parsedResponse.size() - 1);
        String actuatext = lastfact.get("text").toString();
        String expected="Cats are the most popular pet in the United States: There are 88 million pet cats and 74 million dogs.";
        Assert.assertEquals(expected,actuatext);
    }
}
