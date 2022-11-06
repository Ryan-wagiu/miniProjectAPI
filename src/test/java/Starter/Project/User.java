package Starter.Project;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;

public class User {
    private String url, token;

    public void setUrlGetUser(){
        url = "https://alta-shop.herokuapp.com/api/auth/info";
        token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkltYW51ZWwgcnlhbiB3YWdpdSIsIkVtYWlsIjoiaW1hbnVlbEBnbWFpbC5jb20ifQ.aMFEdmXyxScZzBq4r2xLDcTJEl2BJiZ2h7yqeWx8N98";
    }
    public void requestGet(){
        given().header("Content-Type"," application/json")
                .header("Authorization","Bearer " + token)
                .when().get(url);
    }

    public void verifStatusCode200(){
        then().statusCode(200);
    }
}
