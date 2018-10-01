package com.dailycalculator.tippmix.repository;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailycalculator.tippmix.model.Profit;

public interface ProfitRepository extends JpaRepository<Profit, Long> {

	public Collection<Profit> findWeekly(LocalDateTime time);
	public Collection<Profit> findMonthly(LocalDateTime time);
	public Collection<Profit> findDaily(LocalDateTime time);

}
