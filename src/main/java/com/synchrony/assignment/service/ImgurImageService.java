package com.synchrony.assignment.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.synchrony.assignment.album.response.AlbumResponse;
import com.synchrony.assignment.imgur.response.ImageCreationResponse;

@Service
public interface ImgurImageService {

	public ImageCreationResponse addImage(String albumId,MultipartFile file);

	public String deleteImage(String imageId);

	public AlbumResponse viewImages(String albumId);
}
