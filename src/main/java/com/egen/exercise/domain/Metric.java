package com.egen.exercise.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.PrePersist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@XmlRootElement(name = "metric")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity(value="Metrics", noClassnameStored = true)
public final class Metric {

	@Id
	private ObjectId id;
	private Float baseWeight;
	private Float currentWeight;
	private Date creationDate;
	
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
	
	@PrePersist
	public void prePersist() {
		this.creationDate = new Date();
	}

	@Override
	public String toString() {
		return "Metric [id=" + id + ", baseWeight=" + baseWeight + ", currentWeight=" + currentWeight
				+ ", creationDate=" + creationDate + "]";
	}

}
