package com.legallease.firmranking;

import com.legallease.firmranking.model.FirmRanking;
import com.legallease.firmranking.service.FirmRankingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class FirmRankingController {

    @Autowired
    FirmRankingServiceImpl firmRankingService;

    @GetMapping("/firmRanking/{regionId}")
    public ResponseEntity<List<FirmRanking>> firmRanking(@PathVariable long regionId) {

        if (regionId != 170L) {
            return badRequest().build();
        }

        return ok( firmRankingService.getFirmRankingWithRegionId(regionId) );
    }
}

