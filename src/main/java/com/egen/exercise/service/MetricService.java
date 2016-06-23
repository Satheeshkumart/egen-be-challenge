package com.egen.exercise.service;

import org.easyrules.api.RulesEngine;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egen.exercise.domain.Alert;
import com.egen.exercise.domain.Metric;
import com.egen.exercise.rule.AlertRule;
import com.egen.exercise.utils.MongoConnectionManager;

@Service
public class MetricService {
	
	@Autowired
	RulesEngine rulesEngine;
	
	public void create(Metric metric) {
		
		Datastore datastore = MongoConnectionManager.instance().getDb();
		
		datastore.save(metric);
		
		Alert alert = new Alert();
		BeanUtils.copyProperties(metric, alert);
		
		AlertRule alertRule = new AlertRule(alert);
		
		rulesEngine.registerRule(alertRule);
		
		rulesEngine.fireRules();
		
		if (alert.getAlert()) {
			datastore.save(alert);
		}
		
		rulesEngine.clearRules();
	}
}
