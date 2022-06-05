package com.example.graphql.services;

import com.example.graphql.model.product.ProductMetaField;
import com.example.graphql.model.product.Products;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.graphql.client.ClientResponseField;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class GraphQLServices {

    private final String SHOP_URL = "https://tb-jm.myshopify.com/admin/api/2021-04/graphql.json";
    private final String AUTHOR_HEADER = "X-Shopify-Access-Token";

    @Value("${shopify.key}")
    private String AUTHOR_KEY ;
    public Products getProduct() {
        ObjectMapper objectMapper = new ObjectMapper();
        WebClient webClient = WebClient.builder()
                .baseUrl(SHOP_URL)
                .defaultHeader(AUTHOR_HEADER, AUTHOR_KEY)
                .build();

        GraphQLWebClient graphqlClient = GraphQLWebClient.newInstance(webClient, objectMapper);

//        ProductMetaField productMetaField = graphqlClient.post("product.graphql"
//                , Map.of("id", "Z2lkOi8vc2hvcGlmeS9Qcm9kdWN0LzY2MzIwOTA3NjM0MTY=")
//                , ProductMetaField.class).block();

        return graphqlClient.post("product.graphql"
                , Map.of("id", "Z2lkOi8vc2hvcGlmeS9Qcm9kdWN0LzY2MzIwOTA3NjM0MTY=")
                , Products.class).block();


//        return productMetaField.getProduct();
    }


}
