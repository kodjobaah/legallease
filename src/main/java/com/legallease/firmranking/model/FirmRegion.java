package com.legallease.firmranking.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Data
@SuperBuilder(toBuilder = true)
@Jacksonized
public class FirmRegion {

    private Long id;
    private Region region;
    private Boolean booking;
    private CrossBorderCapability crossBorderCapability;
    private Integer clientSatisfactionRating;
    private Integer expertiseAndReputationRating;

}
