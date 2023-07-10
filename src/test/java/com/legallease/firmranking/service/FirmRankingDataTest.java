package com.legallease.firmranking.service;

import com.legallease.firmranking.model.FirmRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@DisplayName("Test for fetching the test data")
@SpringBootTest
public class FirmRankingDataTest {

    @Autowired
    FirmRankingData firmRankingData;

    @Test
    @DisplayName("Get Firm Ranking data")
    public void getFirmRankingDataShouldReturnTheTestData() {

        List<FirmRanking> results = firmRankingData.getFirmRankingData();
        assertThat(results.size(), equalTo(8));
    }

}
