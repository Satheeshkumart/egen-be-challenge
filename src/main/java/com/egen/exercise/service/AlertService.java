package com.egen.exercise.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.springframework.stereotype.Service;

import com.egen.exercise.domain.Alert;
import com.egen.exercise.utils.ApplicationConstants;
import com.egen.exercise.utils.MongoConnectionManager;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class AlertService {

	public List<Alert> getAlerts() {
		List<Alert> alerts = new ArrayList<>();
		
		Datastore datastore = MongoConnectionManager.instance().getDb();
		alerts = datastore.find(Alert.class).asList();
		
		return alerts;
	}
	
	public List<Alert> getAlertsByTimeRange(String startDate, String endDate) {
		List<Alert> alerts = new ArrayList<>();
		
		Datastore datastore = MongoConnectionManager.instance().getDb();
		
		Date dStartDate = getDate(startDate);
		Date dEndDate = getDate(endDate);
		
		alerts = datastore.find(Alert.class).field("creationDate").greaterThanOrEq(dStartDate).field("creationDate").lessThanOrEq(dEndDate).asList();
		return alerts;
	}
	
	public Date getDate(String strDate) {
		
		DateFormat formatter = new SimpleDateFormat(ApplicationConstants.DATE_FORMAT);
		Date date = null;
		try {
			date = formatter.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(date);
		return date;
		
	}
}
