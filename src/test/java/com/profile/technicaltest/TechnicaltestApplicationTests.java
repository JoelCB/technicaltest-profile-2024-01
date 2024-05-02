package com.profile.technicaltest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.profile.technicaltest.application.response.SearchPriceResponse;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class TechnicaltestApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void test1OnlyOnePriceInDateRange() throws Exception {

		SearchPriceResponse response = performOkSearchCall("35455", "1", "2020-06-14T10:00:00");
		assertEquals(1, response.getPriceList());
	}

	@Test
	void test2TwoPricesDifferentPriority() throws Exception {

		SearchPriceResponse response = performOkSearchCall("35455", "1", "2020-06-14T16:00:00");
		assertEquals(2, response.getPriceList());
	}

	@Test
	void test3OnlyOnePriceInDateRange() throws Exception {

		SearchPriceResponse response = performOkSearchCall("35455", "1", "2020-06-14T21:00:00");
		assertEquals(1, response.getPriceList());
	}

	@Test
	void test4OnlyOnePriceInDateRange() throws Exception {

		SearchPriceResponse response = performOkSearchCall("35455", "1", "2020-06-15T10:00:00");
		assertEquals(3, response.getPriceList());
	}

	@Test
	void test5OnlyOnePriceInDateRange() throws Exception {

		SearchPriceResponse response = performOkSearchCall("35455", "1", "2020-06-16T21:00:00");
		assertEquals(4, response.getPriceList());
	}

	@Test
	void testNotFound() throws Exception {

		performSearchCall("35456", "1", "2020-06-14T10:00:00")
				.andExpect(status().isNotFound());
	}

	@Test
	void testBadRequest() throws Exception {

		performSearchCall("35455", "1A", "2020-06-14T10:00:00")
				.andExpect(status().isBadRequest());
	}

	private SearchPriceResponse performOkSearchCall(String productId, String brandId, String date) throws Exception {

		String bodyContent = performSearchCall(productId, brandId, date)
				.andExpect(status().isOk())
				.andReturn()
				.getResponse().getContentAsString();

		ObjectMapper mp = new ObjectMapper();
		mp.findAndRegisterModules();

		return mp.readValue(bodyContent, SearchPriceResponse.class);
	}

	private ResultActions performSearchCall(String productId, String brandId, String date) throws Exception {

		MockHttpServletRequestBuilder requestBuilder = get("/v1/prices")
				.queryParam("productId", productId)
				.queryParam("brandId", brandId)
				.queryParam("date", date);

		return mvc.perform(requestBuilder);
	}

}
