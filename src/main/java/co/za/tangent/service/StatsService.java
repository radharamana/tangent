package co.za.tangent.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import co.za.tangent.domain.Employee;
import co.za.tangent.domain.Stats;
import co.za.tangent.domain.enums.Gender;
import co.za.tangent.domain.enums.Race;
import co.za.tangent.util.LocalDateTI;

@Service
public class StatsService {
	
	private Stats stats = new Stats();
	
	LocalDateTI localDate;
	
	public StatsService(LocalDateTI localDate) {
		super();
		this.localDate = localDate;
	}

	public void doPopulateStatistics(List<Employee> employees){
		stats.setCountAll(employees.size());
		stats.setBirthDaysThisMonth(employees.stream()
				.filter(e->e.getBirthDate().getMonth().equals(localDate.now().getMonth()))
				.collect(Collectors.toList()));
		
		stats.setCountByGender(employees.stream()
				.collect(Collectors.groupingBy(Employee::getGender,Collectors.counting())));
		Arrays.asList(Gender.values()).forEach(g->{
			if(stats.getCountByGender().get(g)==null)
				stats.getCountByGender().put(g, 0l);});
		
		stats.setCountByRace(employees.stream()
				.collect(Collectors.groupingBy(Employee::getRace,Collectors.counting())));
		Arrays.asList(Race.values()).forEach(r->{
			if(stats.getCountByRace().get(r)==null)
				stats.getCountByRace().put(r, 0l);});
		
		
		stats.setCountByPosition(employees.stream()
				.collect(Collectors.groupingBy(e->e.getPosition().getId(),Collectors.counting())));
		
	}

	public Stats getStats() {
		return stats;
	}
}
