package com.legallease.firmranking.service;

import com.legallease.firmranking.model.FirmRanking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FirmRankingServiceImpl implements FirmRankingService {

    @Autowired
    FirmRankingData firmRankingData;

    @Override
    public List<FirmRanking> getFirmRankingWithRegionId(Long regionId) {
        List<FirmRanking> firmRankings = firmRankingData.getFirmRankingData();

        List<FirmRanking> rankings = firmRankings.stream().filter(firmRanking ->
                firmRanking.getFirm().getFirmRegions().stream()
                        .anyMatch(firmRegion -> firmRegion.getRegion().getId().equals(regionId))).collect(Collectors.toList());
        return rankings;
    }
}
