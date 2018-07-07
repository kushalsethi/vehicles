package com.kushals.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kushals.exception.ErrorLog;
import com.kushals.exception.ReportGenerationException;
import com.kushals.model.Report;
import com.kushals.service.ReportGenerator;
import com.kushals.service.StorageService;

@CrossOrigin
@RestController
@RequestMapping("/vehicles")
public class AppController {

	List<String> files = new ArrayList<>();

	@Autowired
	StorageService storageService;

	@Autowired
	ReportGenerator reportGenerator;

	@GetMapping("/test")
	public String test() {
		return "running";
	}

	@PostMapping("/report")
	public ResponseEntity<Report> getReport(@RequestParam("file") MultipartFile file) throws ReportGenerationException {
		Report report = null;
		try {
			storageService.store(file);
			files.add(file.getOriginalFilename());
			report = reportGenerator.generateReport(storageService.getFile(file));
		} catch (Exception e) {
			throw new ReportGenerationException("Could not generate report for the requested file.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(report);
	}

	@GetMapping("/getreports/{name:.+}")
	public ResponseEntity<Report> getAllReports(@PathVariable("name") String name) throws ReportGenerationException {
		Report report = null;
		try {
			report = reportGenerator.getReport(name);
		} catch (Exception e) {
			throw new ReportGenerationException("Could not generate report for the requested file.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(report);
	}

	@GetMapping("/list")
	public ResponseEntity<List<String>> getReportList() throws ReportGenerationException {
		List<String> reportList = reportGenerator.getAllReportsList();
		return ResponseEntity.status(HttpStatus.OK).body(reportList);
	}

	@ExceptionHandler(ReportGenerationException.class)
	public ResponseEntity<ErrorLog> handleInvalidWordNumberRequest(ReportGenerationException e) {
		ErrorLog errorLog = new ErrorLog(HttpStatus.BAD_REQUEST.getReasonPhrase(), e.getMessage());
		return new ResponseEntity<ErrorLog>(errorLog, HttpStatus.BAD_REQUEST);
	}

}
