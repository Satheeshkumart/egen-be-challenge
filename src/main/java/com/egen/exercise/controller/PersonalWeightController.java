package com.egen.exercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.egen.exercise.domain.Alert;
import com.egen.exercise.domain.AlertResponse;
import com.egen.exercise.domain.Confirmation;
import com.egen.exercise.domain.Metric;
import com.egen.exercise.domain.MetricResponse;
import com.egen.exercise.service.AlertService;
import com.egen.exercise.service.MetricService;

@RestController
public class PersonalWeightController {

	@Autowired
	MetricService metricService;
	
	@Autowired
	AlertService alertService;
	
	@RequestMapping(
			value = "/createMetrics", 
			method = RequestMethod.POST, 
			produces = {
					MediaType.APPLICATION_JSON_VALUE, 
					MediaType.APPLICATION_XML_VALUE }, 
			consumes = {
					MediaType.APPLICATION_JSON_VALUE, 
					MediaType.APPLICATION_XML_VALUE
			})
	public ResponseEntity<?> createMetrics(@RequestBody Metric metric) {
		
		System.out.println(metric.toString());
		
		metricService.create(metric);
		
		MetricResponse response = new MetricResponse();
		Confirmation confirmation = new Confirmation();
		confirmation.setMessage("Success");
		response.setConfirmation(confirmation);
		return ResponseEntity.ok(response);
	}
	
	@RequestMapping(
			value = "/getAlerts", 
			method = RequestMethod.GET, 
			produces = {
					MediaType.APPLICATION_JSON_VALUE, 
					MediaType.APPLICATION_XML_VALUE }
			)
	public ResponseEntity<?> getAlerts() {
		
		List<Alert> alerts = alertService.getAlerts();
		
		AlertResponse response = new AlertResponse();
		response.setAlerts(alerts);
		return ResponseEntity.ok(response);
	}
	
	@RequestMapping(
			value = "/getAlertsByTimeRange", 
			method = RequestMethod.GET, 
			produces = {
					MediaType.APPLICATION_JSON_VALUE, 
					MediaType.APPLICATION_XML_VALUE }
			)
	public ResponseEntity<?> getAlertsByTimeRange(@RequestParam String startDate , @RequestParam String endDate) {
		
		List<Alert> alerts = alertService.getAlertsByTimeRange(startDate, endDate);
		
		AlertResponse response = new AlertResponse();
		response.setAlerts(alerts);
		return ResponseEntity.ok(response);
	}
}
