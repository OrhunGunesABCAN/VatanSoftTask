package vatanSoft.task;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import vatanSoft.baseUrl.BaseUrl;

import java.util.ArrayList;
import java.util.List;


import static io.restassured.RestAssured.given;

public class Task extends BaseUrl {


    @Test()
    public void getRequest() {
        spec.pathParam("first", "woof.json");

        List<Object> byteBuyuk = new ArrayList<>();
        List<Object> byteKucuk = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Response response = given(spec).when().get("{first}");

            JsonPath jsonPath = response.jsonPath();

            if (jsonPath.getInt("fileSizeBytes") >= 1050000) {
                byteBuyuk.add(jsonPath.getString("fileSizeBytes"));
            } else {
                byteKucuk.add(jsonPath.getString("fileSizeBytes"));
            }
        }

        System.out.println("byteKucuk = " + byteKucuk);
        System.out.println("byteBuyuk = " + byteBuyuk);
        System.out.println("byteKucuk.size() = " + byteKucuk.size());
        System.out.println("byteBuyuk.size() = " + byteBuyuk.size());


    }


}
