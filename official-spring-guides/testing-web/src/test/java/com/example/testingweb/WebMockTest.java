package com.example.testingweb;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GreetingController.class)
public class WebMockTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private GreetingService greetingService;

  @Test
  public void greetingShouldReturnGreetingFromService() throws Exception {
    Mockito.when(greetingService.greet()).thenReturn("Hi there, I'm a mock!");
    mockMvc.perform(get("/greeting"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Hi there, I'm a mock!")));
  }


}
