package org.artrun.web.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity(name = "ar_order")
@Data
public class Order extends AbstractEntity{

    @OneToOne
    @JoinColumn(name = "id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;
    
    private String address;

    private OrderStatus status;

}
