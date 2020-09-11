package com.cognizant.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;


@Data

public class BookModel {
	
	private Long id;
	private String title;
	private String author;
	private Double price;
	private String language;
}
