package vatanSoft.baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;

public class BaseUrl {
    protected RequestSpecification spec;

    @BeforeEach
    public void setUp() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://random.dog/")//Base Url i ayarladik
                .setContentType(ContentType.JSON)
                .build();
    }
}
