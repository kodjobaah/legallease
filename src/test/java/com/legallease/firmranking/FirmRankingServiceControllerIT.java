package com.legallease.firmranking;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.legallease.firmranking.model.FirmRanking;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FirmRankingServiceControllerIT {

    @Autowired
    private TestRestTemplate template;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getFirmRankings() throws Exception {
        ResponseEntity<String> response = template.getForEntity("/firmRanking/170", String.class);
        List<FirmRanking> firmRankings = objectMapper.readValue(response.getBody(), new TypeReference<List<FirmRanking>>() {
        });

        assertThat(firmRankings.size(), equalTo(8));
    }
}
