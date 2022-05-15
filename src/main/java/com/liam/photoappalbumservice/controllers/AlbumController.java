package com.liam.photoappalbumservice.controllers;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.liam.photoappalbumservice.models.AlbumEntity;
import com.liam.photoappalbumservice.services.AlbumService;

import shared.AlbumDTO;

@RestController
public class AlbumController {
	
	@Autowired
    AlbumService albumServ;
	
    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @GetMapping( 
            produces = { 
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE,
            })
    public List<AlbumEntity> userAlbums(@PathVariable String id) {

        List<AlbumEntity> returnValue = new ArrayList<>();
        
        List<AlbumDTO> albumsEntities = albumServ.getAlbums(id);
        
        if(albumsEntities == null || albumsEntities.isEmpty())
        {
            return returnValue;
        }
        
        Type listType = new TypeToken<List<AlbumEntity>>(){}.getType();
 
        returnValue = new ModelMapper().map(albumsEntities, listType);
        logger.info("Returning " + returnValue.size() + " albums");
        return returnValue;
    }

}
