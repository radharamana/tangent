package co.za.tangent.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import co.za.tangent.domain.enums.Gender;
import co.za.tangent.domain.enums.Race;

public class Statistics {
	private Map<Race,Integer> countByRace = new HashMap<Race, Integer>();
	private Map<Gender, Integer> countByGender = new HashMap<Gender, Integer>();
	private Integer countAll;
	private List<Employee> birthDaysThisMonth;
	private SortedMap<Position, Integer> countByPosition = new TreeMap<Position, Integer>();
	public Map<Race, Integer> getCountByRace() {
		return countByRace;
	}
	public void setCountByRace(Map<Race, Integer> countByRace) {
		this.countByRace = countByRace;
	}
	public Map<Gender, Integer> getCountByGender() {
		return countByGender;
	}
	public void setCountByGender(Map<Gender, Integer> countByGender) {
		this.countByGender = countByGender;
	}
	public Integer getCountAll() {
		return countAll;
	}
	public void setCountAll(Integer countAll) {
		this.countAll = countAll;
	}
	public List<Employee> getBirthDaysThisMonth() {
		return birthDaysThisMonth;
	}
	public void setBirthDaysThisMonth(List<Employee> birthDaysThisMonth) {
		this.birthDaysThisMonth = birthDaysThisMonth;
	}
	public SortedMap<Position, Integer> getCountByPosition() {
		return countByPosition;
	}
	public void setCountByPosition(SortedMap<Position, Integer> countByPosition) {
		this.countByPosition = countByPosition;
	}
	
	
}
