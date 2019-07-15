package com.hc.jee.currencyconversionservice.model;

import java.math.BigDecimal;

public class CurrencyConversionBean {

	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal quntity;
	private BigDecimal totalCalculateAmount;
	private int port;

	public CurrencyConversionBean(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quntity,
			BigDecimal totalCalculateAmount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quntity = quntity;
		this.totalCalculateAmount = totalCalculateAmount;
		this.port = port;
	}

	public CurrencyConversionBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public BigDecimal getQuntity() {
		return quntity;
	}

	public void setQuntity(BigDecimal quntity) {
		this.quntity = quntity;
	}

	public BigDecimal getTotalCalculateAmount() {
		return totalCalculateAmount;
	}

	public void setTotalCalculateAmount(BigDecimal totalCalculateAmount) {
		this.totalCalculateAmount = totalCalculateAmount;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
