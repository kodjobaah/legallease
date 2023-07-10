package com.legallease.firmranking.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Data
@SuperBuilder(toBuilder = true)
@Jacksonized
public class Firm {

    private Long id;
    private String name;
    private String slug;
    private String imageUrl;
    private String websiteUrl;
    private List<Badge> badges;
    private List<Award> awards;
    private List<FirmRegion> firmRegions;

}
