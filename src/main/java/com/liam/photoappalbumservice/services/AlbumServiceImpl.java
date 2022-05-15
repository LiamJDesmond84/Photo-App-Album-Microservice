package com.liam.photoappalbumservice.services;

import java.util.ArrayList;
import java.util.List;

import shared.AlbumDTO;

public class AlbumServiceImpl implements AlbumService {

	@Override
    public List<AlbumDTO> getAlbums(String userId) {
        List<AlbumDTO> returnValue = new ArrayList<>();
        
        AlbumDTO albumDTO = new AlbumDTO();
        albumDTO.setUserId(userId);
        albumDTO.setAlbumId("album1Id");
        albumDTO.setDescription("album 1 description");
        albumDTO.setId(1L);
        albumDTO.setName("album 1 name");
        
        AlbumDTO albumDTO2 = new AlbumDTO();
        albumDTO2.setUserId(userId);
        albumDTO2.setAlbumId("album2Id");
        albumDTO2.setDescription("album 2 description");
        albumDTO2.setId(2L);
        albumDTO2.setName("album 2 name");
        
        returnValue.add(albumDTO);
        returnValue.add(albumDTO2);
        
        return returnValue;
    }

	
}
