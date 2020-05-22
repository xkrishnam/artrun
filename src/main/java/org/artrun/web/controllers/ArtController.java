package org.artrun.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.artrun.web.domain.Painting;
import org.artrun.web.dto.PaintingDto;
import org.artrun.web.repositories.PaintingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtController {
	
	@Autowired
	private PaintingRepository pRepository;

	@GetMapping(value = "/getallart")
	public @ResponseBody List<PaintingDto>  getAllPaintings(){
		List<Painting> a=pRepository.findAll();
		List<PaintingDto> paintings=new ArrayList<>();
		a.stream().forEach(p->{paintings.add(new PaintingDto(p));});
		return paintings;
	}
	
	@GetMapping(value = "/art/{id}")
	public @ResponseBody PaintingDto getArtById(@PathVariable("id") Long id){
		Painting p=pRepository.getOne(id);
		return new PaintingDto(p);
	}
}