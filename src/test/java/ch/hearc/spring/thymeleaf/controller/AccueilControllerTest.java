package ch.hearc.spring.thymeleaf.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import ch.hearc.spring.thymeleaf.service.UnitTestExampleService;

@RunWith(SpringRunner.class)
@WebMvcTest(AccueilController.class)
public class AccueilControllerTest {

	@Autowired
    private MockMvc mvc;
 
	//Mock de la couche service
    @MockBean
    private UnitTestExampleService service;
    
	@Test
	public void whenCallUnitTestApi_thenResponseIsCorrect() throws Exception {
		
		Mockito.when(service.getMessage()).thenReturn("ok");
		
		mvc.perform(get("/unit-test")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(content().string("ok"))
				.andExpect(status().isOk());
	}
}
