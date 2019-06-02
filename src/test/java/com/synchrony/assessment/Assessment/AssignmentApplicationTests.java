package com.synchrony.assessment.Assessment;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.synchrony.assignment.beans.UserAddress;
import com.synchrony.assignment.beans.UserInformation;

/*@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
*/public class AssignmentApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private MockMvc mockMvc;

	//@Test
	public void shouldReturnDefaultMessage() throws Exception {

		UserInformation userInformation = new UserInformation();
		userInformation.setUserName("induri");
		userInformation.setPassword("induri");
		UserAddress address = new UserAddress();
		address.setCity("Hyderabad");
		// userInformation.setAddress(address);
		ObjectMapper objMapper = new ObjectMapper();
		String jsonString = objMapper.writeValueAsString(userInformation);

		this.mockMvc
				.perform(post("/assessment/user/register").contentType(MediaType.APPLICATION_JSON).content(jsonString))
				.andExpect(status().isOk());
	}

}
