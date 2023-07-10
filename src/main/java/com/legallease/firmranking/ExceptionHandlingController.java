package com.legallease.firmranking;

import com.legallease.firmranking.exception.FirmRankingDataNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.ResponseEntity.status;

@RestControllerAdvice
public class ExceptionHandlingController {

	@ExceptionHandler( FirmRankingDataNotFoundException.class )
	public ResponseEntity<ErrorResponse> firmRankingDataFotFound( FirmRankingDataNotFoundException e ) {

		return status( NOT_FOUND )
				.body( ErrorResponse.builder()
						.message( format( "Firm Ranking Data file was not found %s", e.getMessage() ) )
						.build() );
	}
}