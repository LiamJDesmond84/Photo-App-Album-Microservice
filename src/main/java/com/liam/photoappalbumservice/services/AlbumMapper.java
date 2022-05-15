package com.liam.photoappalbumservice.services;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.liam.photoappalbumservice.models.AlbumEntity;

import shared.AlbumDTO;

@Mapper(componentModel = "spring")
public interface AlbumMapper {
	
	AlbumMapper INSTANCE = Mappers.getMapper(AlbumMapper.class);
	
	
//	User sourceToDestination(UserDTO userDTO);
//	UserDTO destinationToSource(User user);
	
	AlbumDTO sourceToDestination(AlbumEntity album);
	
	AlbumEntity destinationToSource(AlbumDTO albumDTO);

}
