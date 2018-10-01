package com.dailycalculator.tippmix.services;

public interface ProfitService {
	
	public Double calculateProfitDaily();
	public Double calculateProfitWeekly();
	public Double calculateProfitMonthly();
	public Double calculatePossibleProfit(Double base, Double odds);
	public Double calculateBase();
	public Boolean shouldIStop();
}
