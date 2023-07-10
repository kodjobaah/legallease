package com.legallease.firmranking.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Data
@SuperBuilder(toBuilder = true)
@Jacksonized
public class RegionGroup {

    private Long id;
    private String name;
    private String slug;
    private RegionArea regionArea;

}
