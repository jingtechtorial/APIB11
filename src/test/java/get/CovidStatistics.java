package get;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class CovidStatistics {
    @Test
    public void Covidstastics(){
    Response response= RestAssured.given().header("Accept","application/json")//requestspecification
            .when()//click send
            .get("https://corona.lmao.ninja/v2/all")//click send
            .then().statusCode(200).extract().response();
        Map<String,Object> deserializedResponse=response.as(new TypeRef<Map<String, Object>>() {
        });
    int affectedCountires=(int)  deserializedResponse.get("affectedCountries");
        System.out.println(deserializedResponse);
        Assert.assertEquals(227,affectedCountires);

}}
