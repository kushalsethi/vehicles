package com.kushals.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Report cannot be generated for requested file.")
public class ReportGenerationException extends Exception {

	public ReportGenerationException(String errorMessage) {
		super(errorMessage);
	}

}
