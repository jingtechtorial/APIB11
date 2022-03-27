package get;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pojo.PokemonPojo;

import java.util.List;
import java.util.Map;

public class Pokemon {
    /*Get https://pokeapi.co/api/v2/pokemon
    *deserialize response with POJO
    * Valiidate the count=1126
    * construct new map of pokemon name(key),url(value)
    *
     */
    @Before
    public void setup(){
        RestAssured.baseURI="https://pokeapi.co";
        RestAssured.basePath="api/v2/pokemon";
    }



    @Test
    public void Pokemontest1(){
        Response response= RestAssured.given().header("Accept","application/json")
                .when().get()
                .then().statusCode(200).extract().response();
        PokemonPojo parsedResponse=response.as(PokemonPojo.class);
        Assert.assertEquals(1126,parsedResponse.getCount());


    }
    @Test
    public void Pokemontest2(){


        Response response= RestAssured.given().header("Accept","application/json")
                .when().get()
                .then().statusCode(200).extract().response();
      JsonPath jsonPath=  response.jsonPath();
      String nextURL=jsonPath.getString("next");
        System.out.println(nextURL);

       String pokemon1Name= jsonPath.getString("results[0].name");
      List<Map<String,String>> resultsList= jsonPath.getList("results");
      for(Map<String,String>pokemon:resultsList){
          System.out.println(pokemon.get("name"));
      }


    }
    @Test
    public void pokemonTest3(){
        RestAssured.given().header("Accept","application/json").log().all()
                .when().get()
                .then().statusCode(200).body("count", Matchers.equalTo(1126));


    }

    }
