package post;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojo.PetPojo;
import utils.PayloadUtil;

public class Pet {
    String petName="miaomiao";
    int petID=1234554;
    String status="sleeping";
    @Test
    public void createPetTest(){

     Response response=   RestAssured.given().header("Accept","application/json")
                .header("Content-Type","application/json")
                .body(PayloadUtil.getPetPayload(petID,petName,status))
                .when().post("https://petstore.swagger.io/v2/pet")
                .then().statusCode(200).extract().response();

            PetPojo parsedResponse = response.as(PetPojo.class);
        Assert.assertEquals(petID,parsedResponse.getId());
        Assert.assertEquals(petName,parsedResponse.getName());
        Assert.assertEquals(status,parsedResponse.getStatus());
        /*add Get https://petstore.swagger.io/v2/pet/{yourPetId}
        validate name,id,status are still same
         */
     Response response1= RestAssured.given().header("Accept","application/json")
                .when().get("https://petstore.swagger.io/v2/pet/"+petID)
                .then().statusCode(200).extract().response();
     PetPojo parsedRespnse1=response1.as(PetPojo.class);
     Assert.assertEquals(petID,parsedRespnse1.getId());
     Assert.assertEquals(petName,parsedRespnse1.getName());
     Assert.assertEquals(status,parsedRespnse1.getStatus());

     /*then().statusCode(200)
     .and()
     .body("id",Matcher.is(1234554)
     .and()
     .body("name",Matcher.equalTo("miaomiao))
     .body("status",Matcher.equalTo("waiting"))
     .body("category.id",Matchers.is(123));
      */
    }
}
