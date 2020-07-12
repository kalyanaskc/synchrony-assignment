package com.kalyan.album.practice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kalyan.album.practice.album.response.AlbumResponse;
import com.kalyan.album.practice.imgur.response.ImageCreationResponse;

@Service
public interface ImgurImageService {

	public ImageCreationResponse addImage(String albumId,MultipartFile file);

	public String deleteImage(String imageId);

	public AlbumResponse viewImages(String albumId);
}
