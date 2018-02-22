package co.za.tangent.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import co.za.tangent.domain.Employee;
import co.za.tangent.domain.Statistics;
import co.za.tangent.domain.enums.Gender;

@Service
public class StatisticsService {
	
	private Statistics statistics;
	
	public void doPopulateStatistics(List<Employee> employees){
		statistics.setCountAll(employees.size());
		statistics.setBirthDaysThisMonth(employees.stream()
				.filter(e->e.getBirthDate().getMonth().equals(LocalDate.now().getMonth()))
				.collect(Collectors.toList()));
		HashMap<Gender, Integer> genderCount = new HashMap<Gender, Integer>();
		employees.stream().collect(Collectors.toMap(Employee::getGender, valueMapper));
		
	}
}
