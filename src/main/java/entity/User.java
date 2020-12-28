package entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "users")
public class User implements Serializable {
	@Id
	private long id;
	private String userName;
	private String userEmail;
	private String userPassword;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> researchAreas;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Embedded
	private Address userAddress;
	
	
	@ElementCollection
	private List<Comment> comments;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(long id, String userName, String userEmail, String userPassword, Set<String> researchAreas,
			Gender gender) {
		super();
		this.id = id;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.researchAreas = researchAreas;
		this.gender = gender;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Set<String> getResearchAreas() {
		return researchAreas;
	}
	public void setResearchAreas(Set<String> researchAreas) {
		this.researchAreas = researchAreas;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Address getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", researchAreas=" + researchAreas + ", gender=" + gender + "]";
	}
	
	
	
	
}
