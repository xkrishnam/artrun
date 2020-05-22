package org.artrun.web.utils;

import java.time.LocalDateTime;

import org.artrun.web.domain.AbstractEntity;

public class GenericUtil<T extends AbstractEntity> {

	public T setCommonDates(T obj) {
		obj.setCreatedDate(LocalDateTime.now());
		obj.setModifiedDate(LocalDateTime.now());
		return obj;
	}
	
	public T setModified(T obj) {
		obj.setModifiedDate(LocalDateTime.now());
		return obj;
	}
}
