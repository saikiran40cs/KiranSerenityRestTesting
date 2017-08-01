package serenityrest.serenity;

import java.util.HashMap;
import java.util.Map;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class WeatherApiSteps {
    @Step
    public void requestWheatherWithCityID(String cityId){
        Map<String, String> params = new HashMap<>();
        params.put("id", cityId);
        SerenityRest.given().contentType("application/json")
                .and().params(params)
                .when().get("api.openweathermap.org/data/2.5/weather");
    }

    @Step
    public void verifyWheatherResponse(){
        System.out.println("verifyWhetherResponse: "+SerenityRest.then().log().all().toString());
        SerenityRest.then().log().all().
                statusCode(200);
    }
}
