package com.ch.jobdamoa.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ScrapJson {

	@SerializedName("title")
	@Expose
	private String title;
	@SerializedName("company")
	@Expose
	private String company;
	@SerializedName("location")
	@Expose
	private String location;
	@SerializedName("experience")
	@Expose
	private String experience;
	@SerializedName("positions")
	@Expose
	private String positions;
	@SerializedName("link")
	@Expose
	private String link;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getPositions() {
		return positions;
	}

	public void setPositions(String positions) {
		this.positions = positions;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
