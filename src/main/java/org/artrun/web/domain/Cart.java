package org.artrun.web.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
@Entity(name = "ar_cart")
public class Cart extends AbstractEntity{

    @OneToMany(fetch = FetchType.EAGER, cascade = {})
    private List<Painting> paintings;    

    @OneToOne(mappedBy = "cart",fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    private Integer cartTotal;

    @Enumerated(EnumType.STRING)
    private CartStatus status;
    
}
