package co.za.tangent.service;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import co.za.tangent.domain.Employee;

@Service
public class PositionService {
	private SortedMap<Long, String> positions = new TreeMap<Long, String>();
	
	public void doPopulatePosition(List<Employee> employees){
		employees.stream().forEach(e->positions.put(e.getPosition().getId(), e.getPosition().getName()));
	}
	
}
