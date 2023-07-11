package com.legallease.firmranking.service;

import com.legallease.firmranking.model.FirmRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static com.legallease.firmranking.TestDataUtils.generateFirmRanking;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@DisplayName("Test for retrieving firm rankings")
class FirmRankingServiceImplTest {

    @InjectMocks
    private FirmRankingServiceImpl firmRankingService;

    @Mock
    private FirmRankingData firmRankingData;

    @Test
    @DisplayName("Get Firm Ranking using region id when only 1 firm ranking")
    public void getFirmRankingWithRegionShouldReturnFirmRankings() {

        long regionId = 100L;
        List<FirmRanking> firmRankings = List.of(generateFirmRanking(regionId));
        when(firmRankingData.getFirmRankingData()).thenReturn(firmRankings);
        List<FirmRanking> results = firmRankingService.getFirmRankingWithRegionId(regionId);

        assertThat(results.size(), equalTo(1));
    }

    @Test
    @DisplayName("Get Firm Ranking using region id when multiple there are firm rankings")
    public void getFirmRankingWithRegionShouldReturnMultipleFirmRankings() {

        long regionId = 100L;
        List<FirmRanking> firmRankings = List.of(
                generateFirmRanking(regionId),
                generateFirmRanking(regionId));
        when(firmRankingData.getFirmRankingData()).thenReturn(firmRankings);
        List<FirmRanking> results = firmRankingService.getFirmRankingWithRegionId(regionId);

        assertThat(results.size(), equalTo(2));
    }

    @Test
    @DisplayName("Get 1 Firm Ranking using region id when multiple firm ranking")
    public void getFirmRankingWithRegionShouldReturnMultipleFirmRankingsInDifferentRegions() {

        long regionId = 100L;
        List<FirmRanking> firmRankings = List.of(
                generateFirmRanking(regionId),
                generateFirmRanking(200L));
        when(firmRankingData.getFirmRankingData()).thenReturn(firmRankings);
        List<FirmRanking> results = firmRankingService.getFirmRankingWithRegionId(regionId);

        assertThat(results.size(), equalTo(1));
    }

    @Test
    @DisplayName("Get Firm Ranking should not return any firm ranking when regionId does not exist")
    public void getFirmRankingWithRegionShouldNotReturnFirmRankingsWhenRegionIdDoesNotExist() {

        Long regionId = 100L;
        List<FirmRanking> firmRankings = List.of(
                generateFirmRanking(300L),
                generateFirmRanking(200L));
        when(firmRankingData.getFirmRankingData()).thenReturn(firmRankings);
        List<FirmRanking> results = firmRankingService.getFirmRankingWithRegionId(regionId);

        assertThat(results.size(), equalTo(0));
    }

}