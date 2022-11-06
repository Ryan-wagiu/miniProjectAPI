package Starter.Project;

import org.json.simple.JSONObject;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;


public class Login {
    private String url;

    public void setUrlApi(){
        url = "https://alta-shop.herokuapp.com/api/auth/login";
    }
    public JSONObject bodyLogin(String email, String password) {
        JSONObject body = new JSONObject();
        body.put("email", email);
        body.put("password", password);
        return body;
    }
    public void requestWithEmailAndPassword(String email, String password){
        given().header("Content-Type"," application/json")
                .body(bodyLogin(email, password))
                .post(url);

    }
    public void verifyStatusCode200(){
        then().statusCode(200);
    }
    public void verifyStatusCode400(){
        then().statusCode(400);
    }
}
