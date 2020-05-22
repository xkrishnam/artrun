package org.artrun.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlaceOrderRequestDTO {
	private Long uid;
	private Long cid;
	private String address;
	private Long oid;
}
