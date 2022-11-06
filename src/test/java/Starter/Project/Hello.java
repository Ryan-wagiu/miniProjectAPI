package Starter.Project;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;

public class Hello {
    private String url;

    public void setUrlHome(){
        url = "https://alta-shop.herokuapp.com/api/hello";
    }
    public void requestHome(){
        given().when().get(url);
    }
    public void verifyStatusCode200(){
        then().statusCode(200);
    }

}
