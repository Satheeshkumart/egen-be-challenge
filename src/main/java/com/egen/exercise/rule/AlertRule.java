package com.egen.exercise.rule;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

import com.egen.exercise.domain.Alert;

@Rule(name = "Alert rule")
public class AlertRule {

	private Float baseWeight;
	private Float currentWeight;
	private static final Float ALERT_MIN_PERCENT_CHANGE = -10.0f;
	private static final Float ALERT_MAX_PERCENT_CHANGE = 10.0f;
	private Alert alert;
	
	public AlertRule( Alert alert) {
		this.baseWeight = alert.getBaseWeight();
		this.currentWeight = alert.getCurrentWeight();
		this.alert = alert;
		alert.setAlert(false);
	}
	
	@Condition
    public boolean when() {
		System.out.println(alert);
		
		Float percentageChange = (((currentWeight-baseWeight) * 100 ) / baseWeight);
		if (percentageChange < ALERT_MIN_PERCENT_CHANGE) {
			return true;
		} else if (percentageChange > ALERT_MAX_PERCENT_CHANGE) {
			return true;
		}
        return false;
    }

    @Action
    public void then() {
    	alert.setAlert(true);
    	Float percentageChange = (((currentWeight-baseWeight) * 100 ) / baseWeight);
		if (percentageChange < ALERT_MIN_PERCENT_CHANGE) {
			alert.setReason("The weight of the person drops below 10 percent of his base weight");
		} else if (percentageChange > ALERT_MAX_PERCENT_CHANGE) {
			alert.setReason("The weight of the person shoots 10 percent over his base weight");
		}
    }
}
