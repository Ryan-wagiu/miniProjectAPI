package Starter.Project;

import Starter.utils.Generated;
import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;

public class Categories {private String url,token,id;

    public void setUrl(){
        url = "https://alta-shop.herokuapp.com/api/categories";
        token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkltYW51ZWwgcnlhbiB3YWdpdSIsIkVtYWlsIjoiaW1hbnVlbEBnbWFpbC5jb20ifQ.aMFEdmXyxScZzBq4r2xLDcTJEl2BJiZ2h7yqeWx8N98";
    }
    public JSONObject bodyCategory(String name, String desc){
        Generated generated = new Generated();
        JSONObject body = new JSONObject();
        if(name.equals("gaming")){
            name = generated.nameCategory();
            desc = generated.descCategory();
        }
        body.put("name", name);
        body.put("desc", desc);
        return body;
    }

    public void requestCategoryWithNameAndDesc(String name, String desc){
        given().header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(bodyCategory(name, desc))
                .post(url);
    }
    public void requestGetById(String getid){
        if (getid.equals("1")){
            id = "1";
        }else if (getid.equals("2")){
            id = "2";
        }
        given().when().get(url + "/" + getid);
    }
    public void requestGetAll(){
        given().when().get(url);
    }
    public void verifStatusCode200(){
        then().statusCode(200);
    }
    public void verifStatusCode400(){
        then().statusCode(400);
    }
    public void verifStatusCode404(){
        then().statusCode(404);
    }
    public void verifStatusCode500(){
        then().statusCode(500);
    }
}
