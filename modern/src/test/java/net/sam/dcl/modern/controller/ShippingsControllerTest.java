package net.sam.dcl.modern.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ShippingsController.class)
class ShippingsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @WithMockUser
    void inputOk() throws Exception {
        mockMvc.perform(get("/shippings"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void postOk() throws Exception {
        mockMvc.perform(post("/shippings")
                        .param("id", "1")
                        .param("action", "save")
                        .param("payload", "test"))
                .andExpect(status().isOk());
    }
}
