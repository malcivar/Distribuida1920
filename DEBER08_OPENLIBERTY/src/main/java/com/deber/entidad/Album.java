package com.deber.entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="album")
public class Album implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Integer album_id;
	@Column(name="singer_id")
	  private Integer singer_id;
	@Column(name="title")
	   private String title;
	@Column(name="release_date")
	   private Date release_date;
	
	//@ManyToOne(fetch = FetchType.LAZY)
  //  @JoinColumn(name="singer_id")
  //  private Singer singer;

	

	public Integer getAlbum_id() {
		return album_id;
	}

	public void setAlbum_id(Integer album_id) {
		this.album_id = album_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

	public Integer getSinger_id() {
		return singer_id;
	}

	public void setSinger_id(Integer singer_id) {
		this.singer_id = singer_id;
	}

	

	
	


	
	
	
}
