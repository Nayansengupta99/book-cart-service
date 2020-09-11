package com.cognizant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;



import lombok.Data;

@XmlRootElement
@Data
@Entity
@Table(name = "cart")


public class CartModel {

@Id
@NotNull
@Column(name="userid")
private Long userId;
@Column(name="bookid")
private Long bookId;



}
