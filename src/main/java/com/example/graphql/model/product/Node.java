package com.example.graphql.model.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Node {

    private String namespace;
    private String key;
    private String valueType;
}
