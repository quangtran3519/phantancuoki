package entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "news")
public class News implements Serializable {
	@Id
	private Long id;
	private String newsTitle;
	private String newsContent;
	private LocalDateTime creationDate;
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> newsCategories;
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> tags;
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> votes;
	
	public News() {
		// TODO Auto-generated constructor stub
	}
	
	public News(Long id, String newTitle, String newsContent, LocalDateTime creationDate, Set<String> newsCategories,
			Set<String> tags, Set<String> votes) {
		super();
		this.id = id;
		this.newsTitle = newTitle;
		this.newsContent = newsContent;
		this.creationDate = creationDate;
		this.newsCategories = newsCategories;
		this.tags = tags;
		this.votes = votes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNewTitle() {
		return newsTitle;
	}

	public void setNewTitle(String newTitle) {
		this.newsTitle = newTitle;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public Set<String> getNewsCategories() {
		return newsCategories;
	}

	public void setNewsCategories(Set<String> newsCategories) {
		this.newsCategories = newsCategories;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	public Set<String> getVotes() {
		return votes;
	}

	public void setVotes(Set<String> votes) {
		this.votes = votes;
	}

	@Override
	public String toString() {
		return "New [id=" + id + ", newTitle=" + newsTitle + ", newsContent=" + newsContent + ", creationDate="
				+ creationDate + ", newsCategories=" + newsCategories + ", tags=" + tags + ", votes=" + votes + "]";
	}
	

}
