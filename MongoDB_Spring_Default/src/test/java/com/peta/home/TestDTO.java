package com.peta.home;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "board")
public class TestDTO {
	private String id;
	private String title;
	
	
	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "TestDTO [id=" + id + ", title=" + title + "]";
	}
	
	
}
