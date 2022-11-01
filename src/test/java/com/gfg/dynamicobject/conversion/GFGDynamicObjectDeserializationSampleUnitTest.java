package com.gfg.dynamicobject.conversion;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GFGDynamicObjectDeserializationSampleUnitTest {

    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
    }

    private String readJsonResource(String jsonPath) {
        try (Scanner scanner = new Scanner(getClass().getResourceAsStream(jsonPath), "UTF-8")) {
            return scanner.useDelimiter("\\A").next();
        }
    }

    @Test
    void jsonString_parsingToJsonNode_resultWillBeDynamicProperties() throws JsonParseException, JsonMappingException, IOException {
        // given
        String givenJson = readJsonResource("/sample-dynamic-object/embedded.json");

        // when
        OnlineShoppingProductJsonNode product = objectMapper.readValue(givenJson, OnlineShoppingProductJsonNode.class);

        // then
        assertThat(product.getProductName()).isEqualTo("Samsung M30");
        assertThat(product.getProductCategory()).isEqualTo("cellphone");
        assertThat(product.getProductDetails().get("audioConnector").asText()).isEqualTo("available");
    }

    @Test
    void jsonString_parsingToMap_resultWillBeDynamicProperties() throws JsonParseException, JsonMappingException, IOException {
        // given
        String givenJson = readJsonResource("/sample-dynamic-object/embedded.json");

        // when
        OnlineShoppingProductMap product = objectMapper.readValue(givenJson, OnlineShoppingProductMap.class);

        // then
        assertThat(product.getProductName()).isEqualTo("Samsung M30");
        assertThat(product.getProductCategory()).isEqualTo("cellphone");
        assertThat(product.getProductDetails().get("audioConnector")).isEqualTo("available");
    }

    @Test
    void jsonString_ParsingWithJsonAnySetter_resultWillBeDynamicProperties() throws JsonParseException, JsonMappingException, IOException {
        // given
        String givenJson = readJsonResource("/sample-dynamic-object/flat.json");

        // when
        OnlineShoppingProduct product = objectMapper.readValue(givenJson, OnlineShoppingProduct.class);

        // then
        assertThat(product.getProductName()).isEqualTo("Samsung M30");
        assertThat(product.getProductCategory()).isEqualTo("cellphone");
        assertThat(product.getProductDetails().get("audioConnector")).isEqualTo("available");
    }

}
