package com.hc.jee.currencyconversionserviceProxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hc.jee.currencyconversionservice.model.CurrencyConversionBean;


//@FeignClient(name = "currency-exchange-service",url="localhost:8000")
@RibbonClient(name="currency-exchange-service")
//@FeignClient(name = "currency-exchange-service") nfaskhouha bech iwali yahki apar zull 
@FeignClient(name="netflix-zuul-api-gateway-server")
public interface CurrencyExchangeServiceProxy {
	
	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public  CurrencyConversionBean retrieveExchangeValue(@PathVariable ("from") String from, @PathVariable ("to")  String  to) ;

}
