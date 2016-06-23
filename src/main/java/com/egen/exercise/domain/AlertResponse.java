package com.egen.exercise.domain;

import java.util.List;

public final class AlertResponse {

	private List<Alert> alerts;
	private ErrorInfo errorInfo;

	public List<Alert> getAlerts() {
		return alerts;
	}

	public void setAlerts(List<Alert> alerts) {
		this.alerts = alerts;
	}

	public ErrorInfo getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}

}
