package net.sam.dcl.modern.controller;

import net.sam.dcl.modern.dto.CommercialProposalDto;
import net.sam.dcl.modern.service.CommercialProposalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CommercialProposalController.class)
class CommercialProposalControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CommercialProposalService commercialProposalService;

    @Test
    @WithMockUser
    void inputOk() throws Exception {
        mockMvc.perform(get("/commercial-proposal"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void postOk() throws Exception {
        when(commercialProposalService.process(any())).thenReturn(new CommercialProposalDto("1", "save", "test"));
        when(commercialProposalService.filterByProcedure(anyString())).thenReturn(List.of());

        mockMvc.perform(post("/commercial-proposal")
                        .param("id", "1")
                        .param("action", "save")
                        .param("payload", "test"))
                .andExpect(status().isOk());
    }
}
