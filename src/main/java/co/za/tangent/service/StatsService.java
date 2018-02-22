package co.za.tangent.service;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import co.za.tangent.domain.Employee;
import co.za.tangent.domain.Stats;

@Service
public class StatsService {
	
	private Stats stats = new Stats();
	
	public void doPopulateStatistics(List<Employee> employees){
		stats.setCountAll(employees.size());
		stats.setBirthDaysThisMonth(employees.stream()
				.filter(e->e.getBirthDate().getMonth().equals(LocalDate.now().getMonth()))
				.collect(Collectors.toList()));
		stats.setCountByGender(employees.stream()
				.collect(Collectors.groupingBy(Employee::getGender,Collectors.counting())));
		
		stats.setCountByRace(employees.stream()
				.collect(Collectors.groupingBy(Employee::getRace,Collectors.counting())));
		
		stats.setCountByPosition(employees.stream()
				.collect(Collectors.groupingBy(e->e.getPosition().getId(),Collectors.counting())));
		
	}

	public Stats getStats() {
		return stats;
	}
}
