package com.hc.jee.exchangevlaue.Repository;

import org.springframework.data.repository.CrudRepository;

import com.hc.jee.exchangevlaue.model.ExchangeValue;

public interface ExchangeValueRepository  extends CrudRepository<ExchangeValue,Long> {
	
	public  ExchangeValue      findByFromAndTo(String from, String to);

}
