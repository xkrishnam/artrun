package org.artrun.web.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity(name = "ar_painting")
@Data
public class Painting extends AbstractEntity {
    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User artist;
    private Integer price;

    @Enumerated(value = EnumType.STRING)
    private ArtifactCategory category;
}
