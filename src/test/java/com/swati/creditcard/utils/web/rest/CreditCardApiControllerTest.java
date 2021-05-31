package com.swati.creditcard.utils.web.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swati.creditcard.model.CreditCardBean;
import com.swati.creditcard.service.CreditCardService;
import com.swati.creditcard.web.rest.CreditCardApiController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class CreditCardApiControllerTest {

    public static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json;charset=UTF-8";
    public static final String CREDITCARDS = "/creditcards";
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CreditCardService creditCardService;

    @InjectMocks
    private CreditCardApiController creditCardApiController;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(creditCardApiController).build();
        objectMapper = new ObjectMapper();
    }

    @Ignore
    @Test
    public void retrieve_all_creditcards() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(
                get(CREDITCARDS)
                        .contentType(MediaType.parseMediaType(APPLICATION_JSON_CHARSET_UTF_8))
                        .accept(MediaType.parseMediaType(APPLICATION_JSON_CHARSET_UTF_8)))
                .andExpect(status().isOk()).andReturn();

        String contentResponse = mvcResult.getResponse().getContentAsString();

        final List<CreditCardBean> creditCardBeans = objectMapper.readValue(contentResponse, new TypeReference<List<CreditCardBean>>() {
        });
        Assert.assertEquals("", contentResponse);
        Assert.assertEquals(0, creditCardBeans.size());
    }

    @Test
    public void create_creditcard_mocked_service_with_valid_number() throws Exception {

        // Given
        CreditCardBean creditCardBean =
                new CreditCardBean("5523070182886622", "Swati", 2000D, null);

        // When
        when(creditCardService.create(eq(creditCardBean))).thenReturn(creditCardBean);

        // Then
        final String content = objectMapper.writeValueAsString(creditCardBean);

        MvcResult mvcResult = this.mockMvc.perform(
                post(CREDITCARDS)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(content))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();

        CreditCardBean response = objectMapper.readValue(content, CreditCardBean.class);

        assertEquals("Not as expected", creditCardBean, response);
    }


    @Test
    public void create_creditcard_mocked_service_with_bad_number() throws Exception {

        // Given
        CreditCardBean creditCardBean =
                new CreditCardBean("1234567887654321", "Swati", 2000D, null);

        // When
        when(creditCardService.create(eq(creditCardBean))).thenReturn(creditCardBean);

        // Then
        final String content = objectMapper.writeValueAsString(creditCardBean);

        MvcResult mvcResult = this.mockMvc.perform(
                post(CREDITCARDS)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(content))
                .andDo(print())
                .andExpect(status().isInternalServerError())
                .andReturn();
    }

    @Test
    public void create_creditcard_with_database() throws Exception {

        // Given
        CreditCardBean creditCardBean =
                new CreditCardBean("5497083002781388334", "swati", 2000D, null);

        // Then
        {
            final String content = objectMapper.writeValueAsString(creditCardBean);

            MvcResult mvcResult = this.mockMvc.perform(
                    post(CREDITCARDS)
                            .content(content)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                            .content(content)
            )
                    .andDo(print())
                    .andExpect(status().isCreated())
                    .andReturn();

            CreditCardBean response = objectMapper.readValue(content, CreditCardBean.class);
            assertEquals("Not as expected", creditCardBean, response);
        }
    }
}
