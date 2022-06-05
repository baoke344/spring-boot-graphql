package com.example.graphql;

import com.example.graphql.model.product.Products;
import com.example.graphql.services.GraphQLServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class GraphQLController {

    private GraphQLServices graphQLServices;

    @GetMapping
    public Products getProduct() {
        return graphQLServices.getProduct();
    }
}
