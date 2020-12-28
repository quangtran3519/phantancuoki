package entity;


import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Comment implements Serializable {
	private String commnentContent;
	private LocalDateTime date;
	
	@ManyToOne
	@JoinColumn(name = "newID")
	private News newl;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public String getCommnentContent() {
		return commnentContent;
	}

	public void setCommnentContent(String commnentContent) {
		this.commnentContent = commnentContent;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public News getNewl() {
		return newl;
	}

	public void setNewl(News newl) {
		this.newl = newl;
	}

	public Comment(String commnentContent, LocalDateTime date) {
		super();
		this.commnentContent = commnentContent;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Comment [commnentContent=" + commnentContent + ", date=" + date  + "]";
	}
	
}
