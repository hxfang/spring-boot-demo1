package com.hucode.study;

import com.hucode.study.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles = "test")
public class ApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void test() {
		long userId = 1;
		User user = restTemplate.getForObject("http://localhost:" + port + "/user/" + userId, User.class);
		assertThat(user.getPhone()).isEqualTo("13600136000");


		long userId2 = 2;
		User newUser = new User();
		newUser.setPhone("13800138000");
		newUser.setEmail("hu11@test.com");
		restTemplate.put("http://localhost:" + port + "/user/" + userId2, newUser);

		User testUser = restTemplate.getForObject("http://localhost:" + port + "/user/" + userId2, User.class);
		assertThat(testUser.getPhone()).isEqualTo("13800138000");
	}

}
