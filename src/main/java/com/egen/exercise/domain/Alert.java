package com.egen.exercise.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import com.egen.exercise.utils.ApplicationConstants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

@JsonInclude(Include.NON_NULL)
@XmlRootElement(name = "alert")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(value = "Alerts", noClassnameStored = true)
public final class Alert {

	@Id
	private ObjectId id;
	private Float baseWeight;
	private Float currentWeight;
	private Date creationDate;
	private Boolean alert;
	private String reason;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Float getBaseWeight() {
		return baseWeight;
	}

	public void setBaseWeight(Float baseWeight) {
		this.baseWeight = baseWeight;
	}

	public Float getCurrentWeight() {
		return currentWeight;
	}

	public void setCurrentWeight(Float currentWeight) {
		this.currentWeight = currentWeight;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Boolean getAlert() {
		return alert;
	}

	public void setAlert(Boolean alert) {
		this.alert = alert;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "Alert [id=" + id + ", baseWeight=" + baseWeight + ", currentWeight=" + currentWeight + ", creationDate="
				+ creationDate + ", alert=" + alert + ", reason=" + reason + "]";
	}

}
