package com.liam.photoappalbumservice.controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlbumController {
	
	@Autowired
    AlbumsService albumsService;
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @GetMapping( 
            produces = { 
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE,
            })
    public List<AlbumEntity> userAlbums(@PathVariable String id) {

        List<AlbumEntity> returnValue = new ArrayList<>();
        
        List<AlbumDTO> albumsEntities = albumsService.getAlbums(id);
        
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
