package com.legallease.firmranking;

import com.legallease.firmranking.model.Firm;
import com.legallease.firmranking.model.FirmRanking;
import com.legallease.firmranking.model.FirmRegion;
import com.legallease.firmranking.model.Region;

import java.util.List;

public class TestDataUtils {

    public static FirmRanking generateFirmRanking(long regionId) {
        return FirmRanking.builder().firm(
                Firm.builder().firmRegions(
                        List.of(FirmRegion.builder().region(
                                Region.builder().id(regionId).build()
                        ).build())
                ).build()
        ).build();
    }
}
