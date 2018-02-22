package co.za.tangent.service;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import co.za.tangent.domain.Employee;
import co.za.tangent.domain.Position;

@Service
public class PositionService {
	private SortedMap<Long, Position> positions = new TreeMap<Long, Position>();
	
	public void doPopulatePosition(List<Employee> employees){
		employees.stream().forEach(e->positions.put(e.getPosition().getId(), e.getPosition()));
	}

	public SortedMap<Long, Position> getPositions() {
		return positions;
	}

	public void setPositions(SortedMap<Long, Position> positions) {
		this.positions = positions;
	}
	
	public boolean isPopulated(){
		return positions.size() > 0;
	}
	
}
