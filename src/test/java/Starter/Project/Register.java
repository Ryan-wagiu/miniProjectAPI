package Starter.Project;

import org.json.simple.JSONObject;
import Starter.utils.Generated;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;

public class Register {
    private String url;
    private String Email;

    public void setUrlRegister(){
        url = "https://alta-shop.herokuapp.com/api/auth/register";
    }
    public JSONObject bodyRegister(String email, String password, String fullname){
        Generated generated = new Generated();


        JSONObject body = new JSONObject();
        if (email.equals("naixxy1")){
            email = generated.randomEmail();
            fullname = generated.randomFullname();
            password = generated.randomPassword();
        }
        body.put("email", email);
        body.put("password", password);
        body.put("fullname", fullname);
        return body;
    }

    public void requestWithEmailPasswordAndFullname(String email, String password, String fullname){
        given().header("Content-Type", "application/json")
                .body(bodyRegister(email, password, fullname))
                .post(url);
    }
    public void verifyStatusCode200(){
        then().statusCode(200);
    }public void verifyStatusCode400(){
        then().statusCode(400);
    }
}
