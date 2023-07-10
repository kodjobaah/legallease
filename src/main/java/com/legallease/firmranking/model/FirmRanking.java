package com.legallease.firmranking.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Data
@SuperBuilder(toBuilder = true)
@Jacksonized
public class FirmRanking {

    private Long id;
    private Firm firm;
    private Trend trend;
    private Boolean diversity;
    private Tier tier;
    private Integer position;

}
