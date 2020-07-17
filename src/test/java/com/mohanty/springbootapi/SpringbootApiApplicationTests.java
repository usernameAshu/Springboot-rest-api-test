package com.mohanty.springbootapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
class SpringbootApiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testRepositoryApiStatusCode() {
		get("https://api.github.com/search/repositories?q=2020-07-05&sort=stars&order=desc")
				.then().assertThat().statusCode(200);
	}

	@Test
	public void testUserAccountsApiStatusCode() {
		get("https://api.github.com/search/repositories?q=followers:0&sort=joined&order=asc")
				.then().assertThat().statusCode(200);
	}

}
