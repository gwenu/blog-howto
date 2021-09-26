package ag.howto;

import ag.howto.resource.ModelResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestHTTPEndpoint(ModelResource.class)
public class ModelResourceTest {

    @Test
    public void getModels() {
        String expectedResponse = "[{\"id\":1,\"name\":\"Model_1\",\"description\":\"Model description 1\"}," +
                "{\"id\":2,\"name\":\"Model_2\",\"description\":\"Model description 2\"}]";

        given()
          .when().get()
          .then()
             .statusCode(200)
             .body(is(expectedResponse));
    }

}