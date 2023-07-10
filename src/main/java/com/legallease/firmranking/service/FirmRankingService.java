package com.legallease.firmranking.service;

import com.legallease.firmranking.model.FirmRanking;

import java.util.List;

public interface FirmRankingService {
    public abstract List<FirmRanking> getFirmRankingWithRegionId(Long regionId);
}
