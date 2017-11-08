package main.java.api;

import org.springframework.data.annotation.Id;
import java.util.Date;

public class RockBand {
	
	@Id
	private String id;
	
	private String name;
	private String title;
	private String description;
	private String imageUrl;
	private Date releaseOn;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Date getReleaseOn() {
		return releaseOn;
	}
	public void setReleaseOn(Date releaseOn) {
		this.releaseOn = releaseOn;
	}	
}
