package com.synchrony.assignment.service;

import org.springframework.stereotype.Service;

import com.synchrony.assignment.imgur.response.AlbumCreationResponse;

@Service
public interface ImgurAlbumService {

	public AlbumCreationResponse createAlbum(String userName, String comments);

	public String deleteAlbum(String albumId);

}
