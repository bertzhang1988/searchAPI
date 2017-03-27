package Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*;

@Test
public class itune2 {
	private String url = "https://itunes.apple.com/search";

	@Test(dataProvider = "itunes get")
	public void f(String term, String country, String media, String limit) {
		SoftAssert sa = new SoftAssert();
		Response rs = given().param("term", term).parameter("country", country).param("media", media)
				.param("limit", limit).when().get(url);
		sa.assertEquals(rs.getStatusCode(), 200, " it is not valid request");
		sa.assertAll();
		System.out.println(rs.asString());

	}

	@DataProvider(name = "itunes get")
	public static Object[][] createData() {
		return new Object[][] { { "jack+johnson", "US", "movie", "50" }, { "justin+bieber", "CA", "music", "25" },
				{ "Tina+Arena", "AU", "podcast", "50" } };

	}

}
