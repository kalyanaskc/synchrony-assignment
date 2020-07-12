package com.kalyan.album.practice.service;

import org.springframework.stereotype.Service;

import com.kalyan.album.practice.imgur.response.AlbumCreationResponse;

@Service
public interface ImgurAlbumService {

	public AlbumCreationResponse createAlbum(String userName, String comments);

	public String deleteAlbum(String albumId);

}
