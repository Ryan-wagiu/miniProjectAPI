package Starter.Project;

import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.apache.commons.lang3.ArrayUtils.toArray;

public class Product {
    private String url,url1;

    public void setUrlGetProduct(){
        url = "https://alta-shop.herokuapp.com/api/products/";

    }
    public JSONObject bodyCreate(String name, String desc, Integer price, Integer categories){
        JSONObject body = new JSONObject();

        body.put("name", name);
        body.put("description", desc);
        body.put("price", price);
        body.put("categories", toArray(categories));

        return body;
    }
    public void requestCreate(String name, String desc, Integer price, Integer categories){
        given().header("Content-Type", "application/json")
                .body(bodyCreate(name, desc, price, categories))
                .post(url);
    }
    public void requestDeleteProduct(){
        given().when().delete(url + "1");
    }
    public void requestGetProduct(){
        given().when().get(url);
    }
    public void verifedStatusCode200(){
        then().statusCode(200);
    }
    public void verifedStatusCode400(){
        then().statusCode(400);
    }
    public void verifedStatusCode500(){
        then().statusCode(500);
    }
    public void setUrlGetByIdProduct(){
        url1 = "https://alta-shop.herokuapp.com/api/products/100";
    }
    public void requestById(){
        given().when().get(url1);
    }
}
