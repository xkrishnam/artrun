package org.artrun.web.dto;

import org.artrun.web.domain.Painting;

import lombok.Data;

@Data
public class PaintingDto{
	private String title;
	private String artist;
	private String id; 
	private Integer price;
	private String category;
	
	public PaintingDto(Painting p) {
		super();
		this.title=p.getTitle();
		this.artist=p.getArtist().getUname();
		this.id=String.valueOf(p.getId());
		this.price=p.getPrice();
		this.category=p.getCategory().name();
	}
}