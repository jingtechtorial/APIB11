package get;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
public class DeserializePokeman {
    @Test
    public void pokeman(){
      Response response=  given().when().get("https://pokeapi.co/api/v2/pokemon").then().extract().response();
      try{ Assert.assertTrue(response.statusCode()==200);}
      catch(AssertionError error){error.printStackTrace();}

      Map<String,Object> pokemanresponse=response.as(new TypeRef<Map<String,Object>>(){});
        System.out.println(pokemanresponse);
        List<Map<String,Object>> results=(List<Map<String,Object>>)pokemanresponse.get("results");
        boolean istherebulbasaur=false;
        for(Map<String,Object> info:results){
           // System.out.println(info.get("name"));
            if(info.get("name").toString().equals("bulbasaur")){
                istherebulbasaur=true;
                break;
            }

        }
        Assert.assertTrue("There is no bulbasaur",istherebulbasaur);
    }
}
