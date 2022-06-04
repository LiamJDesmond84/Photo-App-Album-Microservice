package com.liam.photoappalbumservice.services;

import java.util.List;

import shared.AlbumDTO;

public interface AlbumService {

	List<AlbumDTO> getAlbums(Long id);
}
