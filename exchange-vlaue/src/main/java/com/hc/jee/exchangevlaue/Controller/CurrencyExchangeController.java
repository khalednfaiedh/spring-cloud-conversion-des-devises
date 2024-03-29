package com.hc.jee.exchangevlaue.Controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hc.jee.exchangevlaue.Repository.ExchangeValueRepository;
import com.hc.jee.exchangevlaue.model.ExchangeValue;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environement;
	
	@Autowired
	private  ExchangeValueRepository  exchangeValueRepository;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
	//	ExchangeValue exchangeValue = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(3.01));
		ExchangeValue exchangeValue =  exchangeValueRepository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(environement.getProperty("local.server.port")));
		logger.info("{}", exchangeValue);

		return exchangeValue;
	}

}
