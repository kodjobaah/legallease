package com.legallease.firmranking.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Data
@SuperBuilder(toBuilder = true)
@Jacksonized
public class Region {

    private Long id;
    private String name;
    private String slug;
    private RegionGroup regionGroup;

}
