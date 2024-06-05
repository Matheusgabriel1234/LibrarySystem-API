package tech.biblioteca.Biblioteca;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;

import tech.biblioteca.Biblioteca.entities.User;

@TestConfiguration
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class BibliotecaApplicationTests {
	
	@Autowired
	WebTestClient testClient;

	@Test
	void UserTestSuccess() {
		var user = new User(null,"Matheus","Gabriel","111-111-111","matheus@email.com");
		testClient.post().uri("/users").bodyValue(user).exchange().expectStatus().isCreated().expectBody()
		.jsonPath("$").isArray()
		.jsonPath("$.length()").isEqualTo(1)
		.jsonPath("$[0].firstName").isEqualTo(user.getFirstName())
		.jsonPath("$[0].lastName").isEqualTo(user.getLastName())
		.jsonPath("$[0].document").isEqualTo(user.getDocument())
		.jsonPath("$[0].email").isEqualTo(user.getEmail());
		
	}
	
	@Test
	void UserTestFailure() {
	var user = new User(null,"","","","");
	testClient.post().uri("/users").bodyValue(user).exchange().expectStatus().isBadRequest();
	}

}
