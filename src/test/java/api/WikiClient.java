package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class WikiClient {


    public Response getResponse(String country) {

        Response response = RestAssured.given()
                .headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .when()
                .log().all()
                .get("https://restcountries.eu/rest/v2/name/{country}?fullText=true", country)
                .then().contentType(ContentType.JSON).extract().response();

        return response;
    }
}
