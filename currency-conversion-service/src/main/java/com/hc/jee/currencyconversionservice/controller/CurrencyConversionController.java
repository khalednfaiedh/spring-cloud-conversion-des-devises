package com.hc.jee.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hc.jee.currencyconversionservice.model.CurrencyConversionBean;
import com.hc.jee.currencyconversionserviceProxy.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

//	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
//	public  CurrencyConversionBean convertCurrency(@PathVariable String from,@PathVariable String to,@PathVariable  BigDecimal quantity)
//	{
//		return new CurrencyConversionBean(1L, from, to, BigDecimal.ONE, quantity,quantity ,0);
//	}

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		Map<String, String> uriVaraibles = new HashMap<>();
		uriVaraibles.put("from", from);
		uriVaraibles.put("to", to);

		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
				uriVaraibles);

		CurrencyConversionBean response = responseEntity.getBody();
		logger.info("{}", response);
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());

	}

	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency2(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		CurrencyConversionBean currencyConversionBean = proxy.retrieveExchangeValue(from,to);
		

		return new CurrencyConversionBean(currencyConversionBean.getId(), from, to,
				currencyConversionBean.getConversionMultiple(), quantity,
				quantity.multiply(currencyConversionBean.getConversionMultiple()), currencyConversionBean.getPort());
	}
}
