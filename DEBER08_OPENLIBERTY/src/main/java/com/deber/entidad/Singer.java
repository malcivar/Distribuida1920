package com.deber.entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="singer")
public class Singer implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private Integer singer_id;
	@Column(name="first_name")
	   private String first_name;
	@Column(name="last_name")
	   private String last_name;
	@Column(name="birth_date")
	   private Date birth_date;
	
	//@OneToMany(mappedBy = "singer", cascade = CascadeType.ALL)
    //private List<Album> albums = new ArrayList<>();

public Singer() {
		
	}

	public Integer getSinger_id() {
		return singer_id;
	}

	public void setSinger_id(Integer singer_id) {
		this.singer_id = singer_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	
	
	
	
	
}
