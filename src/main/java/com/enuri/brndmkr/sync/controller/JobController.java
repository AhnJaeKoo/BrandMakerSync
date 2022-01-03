package com.enuri.brndmkr.sync.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.enuri.brndmkr.sync.service.JobService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class JobController {

	private final JobService jobService;

	@GetMapping("/job/brandMakerSyncRun")
	public ResponseEntity<String> brandMakerSyncRun() {
		log.info("brandMakerSyncRun~!!");
		return new ResponseEntity<>(jobService.brandMakerSyncJob(), HttpStatus.OK);
	}

	@GetMapping("/job/test")
	public ResponseEntity<String> test() {
		log.info("/job/test~~~~!!");
		return new ResponseEntity<>("test!!!!", HttpStatus.OK);
	}
}
