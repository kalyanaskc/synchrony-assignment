package com.synchrony.assignment.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity(name = "USER_DETAILS")
public class UserInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String userName;

	private String password;

	@Column
	private String albumId;

	@Column(name = "DELETE_ALBUM_ID")
	private String deleteAlbumId;

	private String phoneNumber;

	private String email;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	public String getDeleteAlbumId() {
		return deleteAlbumId;
	}

	public void setDeleteAlbumId(String deleteAlbumId) {
		this.deleteAlbumId = deleteAlbumId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserInformation [id=" + id + ", userName=" + userName + ", password=" + password + ", albumId="
				+ albumId + "]";
	}

}
