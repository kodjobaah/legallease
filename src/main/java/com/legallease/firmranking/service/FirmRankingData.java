package com.legallease.firmranking.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.legallease.firmranking.exception.FirmRankingDataNotFoundException;
import com.legallease.firmranking.model.FirmRanking;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

@Component
public class FirmRankingData {

    @Value("classpath:static/legalease-code-test-api.json")
    Resource firmRankingsResourceFile;

    public List<FirmRanking> getFirmRankingData()  {
        List<FirmRanking> firmRankings;
        try {
            String firmRankingData = firmRankingsResourceFile.getContentAsString(Charset.defaultCharset());
            ObjectMapper mapper  = new ObjectMapper();
            firmRankings = mapper.readValue(firmRankingData, new TypeReference<List<FirmRanking>>(){});

        } catch (IOException e) {
            throw new FirmRankingDataNotFoundException(e);
        }
        return firmRankings;
    }

}
