package com.example.testingweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.hamcrest.Matchers.containsString;

@WebMvcTest
public class WebLayerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void shouldReturnDefaultGreeting() throws Exception {
    mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Hello, World!")));
  }


}
