package com.legallease.firmranking.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Data
@SuperBuilder(toBuilder = true)
@Jacksonized
public class Badge {

    private Long id;
    private String name;
    private String slug;

}
