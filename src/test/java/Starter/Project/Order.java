package Starter.Project;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;

public class Order {
    private String url,token, url1, url2, gid;

    public void setUrlCreateOrder(){

        url = "https://alta-shop.herokuapp.com/api/orders";
        token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkltYW51ZWwgcnlhbiB3YWdpdSIsIkVtYWlsIjoiaW1hbnVlbEBnbWFpbC5jb20ifQ.aMFEdmXyxScZzBq4r2xLDcTJEl2BJiZ2h7yqeWx8N98";
    }
    public List<JSONObject> bodyCreateOrder(int id, int qty){
        JSONObject body = new JSONObject();
        List<JSONObject> data = new ArrayList<>();

        body.put("product_id", id);
        body.put("quantity", qty);
        data.add(body);
        return data;
    }

    public void requestIdAndQty(int id, int qty){
        given().header("Authorization", "Bearer " + token)
                .header("Content-Type", " application/json")
                .body(bodyCreateOrder(id, qty))
                .post(url);
    }


    public void verifyStatusCode200(){
        then().statusCode(200);
    }
    public void verifyStatusCode400(){
        then().statusCode(400);
    }
    public void setUrlGetAllOrder(){
        url1 = "https://alta-shop.herokuapp.com/api/orders/";
        token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkltYW51ZWwgcnlhbiB3YWdpdSIsIkVtYWlsIjoiaW1hbnVlbEBnbWFpbC5jb20ifQ.aMFEdmXyxScZzBq4r2xLDcTJEl2BJiZ2h7yqeWx8N98";
    }
    public void setUrlGetById(String id){
        if (id.equals("1")){
            gid = "1";
        }else if (id.equals("0")){
            gid = "0";
        }
        url2 = "https://alta-shop.herokuapp.com/api/orders/" + gid;
        token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkltYW51ZWwgcnlhbiB3YWdpdSIsIkVtYWlsIjoiaW1hbnVlbEBnbWFpbC5jb20ifQ.aMFEdmXyxScZzBq4r2xLDcTJEl2BJiZ2h7yqeWx8N98";
    }
    public void requestGetById(){
        given().header("Authorization", "Bearer " + token)
                .when().get(url2);
    }
    public void requestGetAll(){
        given().header("Authorization", "Bearer " + token)
                .when().get(url1);
    }
    public void verifyStatusCode404() {
        then().statusCode(404);
    }
}
