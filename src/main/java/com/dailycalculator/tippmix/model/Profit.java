package com.dailycalculator.tippmix.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(value= {@NamedQuery(name="Profit.findDaily", query="select p from Profit p where p.time=?1"),
		@NamedQuery(name="Profit.findMonthly", query="select p from Profit p where p.time=?1"),
		@NamedQuery(name="Profit.findWeekly", query="select p from Profit p where p.time=?1")
})


public class Profit {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime time;
	private Double odds;
	private Double base;
	private Boolean win;
	
	
	
	public Profit() {
		super();
	}

	public Profit(Long id, LocalDateTime time, Double odds, Double base, Boolean win) {
		super();
		this.id = id;
		this.time = time;
		this.odds = odds;
		this.base = base;
		this.win = win;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public Double getOdds() {
		return odds;
	}
	public void setOdds(Double odds) {
		this.odds = odds;
	}
	public Double getBase() {
		return base;
	}
	public void setBase(Double base) {
		this.base = base;
	}
	public Boolean getWin() {
		return win;
	}
	public void setWin(Boolean win) {
		this.win = win;
	}
	
}
