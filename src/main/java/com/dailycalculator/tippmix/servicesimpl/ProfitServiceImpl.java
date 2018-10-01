package com.dailycalculator.tippmix.servicesimpl;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailycalculator.tippmix.model.Profit;
import com.dailycalculator.tippmix.repository.ProfitRepository;
import com.dailycalculator.tippmix.services.ProfitService;

@Service
public class ProfitServiceImpl implements ProfitService {
	
	@Autowired
	ProfitRepository profitrepository;
	
	
	public void saveProfit( Double odds, Double base, Boolean win) {
		Profit p = new Profit(null,LocalDateTime.now(),odds,base,win);
		profitrepository.save(p);
	}
	
	public void generating30Days() {
				
		
	}
	public Double getTodayTarget() {
		return null;
		
		
	}
	
	
		
	
	@Override
	public Double calculateProfitDaily() {
		LocalDateTime oneweekearlier = LocalDateTime.now().minusDays(1);
		Collection<Profit> profits= profitrepository.findDaily(oneweekearlier);
		Double sum = 0.0;
		
		
		Collection<Profit> wins = profits.stream().filter(p -> p.getWin().booleanValue() == true ).collect(Collectors.toList());
		Collection<Profit> looses = profits.stream().filter(p -> p.getWin().booleanValue() == false ).collect(Collectors.toList());

		for (Profit p : wins) {
			sum += (p.getBase() * p.getOdds())-p.getBase();
		}
		for (Profit p : looses) {
			sum += p.getBase();
		}
		
		
		return sum;
	}

	@Override
	public Double calculateProfitWeekly() {
		LocalDateTime oneweekearlier = LocalDateTime.now().minusDays(7);
		Collection<Profit> profits= profitrepository.findDaily(oneweekearlier);
		Double sum = 0.0;
		
		
		Collection<Profit> wins = profits.stream().filter(p -> p.getWin().booleanValue() == true ).collect(Collectors.toList());
		Collection<Profit> looses = profits.stream().filter(p -> p.getWin().booleanValue() == false ).collect(Collectors.toList());

		for (Profit p : wins) {
			sum += (p.getBase() * p.getOdds())-p.getBase();
		}
		for (Profit p : looses) {
			sum += p.getBase();
		}
		
		
		return sum;
	}

	@Override
	public Double calculateProfitMonthly() {
		LocalDateTime oneweekearlier = LocalDateTime.now().minusDays(30);
		Collection<Profit> profits= profitrepository.findDaily(oneweekearlier);
		Double sum = 0.0;
		
		
		Collection<Profit> wins = profits.stream().filter(p -> p.getWin().booleanValue() == true ).collect(Collectors.toList());
		Collection<Profit> looses = profits.stream().filter(p -> p.getWin().booleanValue() == false ).collect(Collectors.toList());

		for (Profit p : wins) {
			sum += (p.getBase() * p.getOdds())-p.getBase();
		}
		for (Profit p : looses) {
			sum += p.getBase();
		}
		
		
		return sum;
	}

	@Override
	public Double calculatePossibleProfit(Double base, Double odds) {		
		return (base*odds)-base;
	}

	@Override
	public Double calculateBase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean shouldIStop() {
		return null;
	}


}
