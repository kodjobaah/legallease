package com.legallease.firmranking;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.legallease.firmranking.model.FirmRanking;
import com.legallease.firmranking.service.FirmRankingServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FirmRankingServiceControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private FirmRankingServiceImpl firmRankingService;

    @Autowired
    private ObjectMapper objectMapper;

    @Captor
    ArgumentCaptor<Long> regionIdCaptor;

    @Test
    @DisplayName("Get Firm Ranking When RegionId is 170")
    public void getFirmRanking() throws Exception {

        List<FirmRanking> firmRankings = List.of( TestDataUtils.generateFirmRanking(100L) );
        when(firmRankingService.getFirmRankingWithRegionId( 170L ))
                .thenReturn( firmRankings );
        mvc.perform(MockMvcRequestBuilders.get("/firmRanking/170").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string( objectMapper.writeValueAsString( firmRankings ) ));

        verify(firmRankingService, times(1))
                .getFirmRankingWithRegionId( regionIdCaptor.capture());

        Long regionId = regionIdCaptor.getValue();
        assertEquals(170L, regionId);
    }

    @Test
    @DisplayName("Should Fail if region id is not 170")
    public void dontGetFirmRanking() throws Exception {

        List<FirmRanking> firmRankings = List.of( TestDataUtils.generateFirmRanking(100L) );
        when(firmRankingService.getFirmRankingWithRegionId( 70L ))
                .thenReturn( firmRankings );
        mvc.perform(MockMvcRequestBuilders.get("/firmRanking/70").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        verify(firmRankingService, never())
                .getFirmRankingWithRegionId(70L);

    }
}