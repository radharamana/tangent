package co.za.tangent.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import co.za.tangent.domain.enums.Gender;
import co.za.tangent.domain.enums.Race;

public class Stats {
	private Map<Race,Long> countByRace;
	private Map<Gender, Long> countByGender;
	private Integer countAll;
	private List<Employee> birthDaysThisMonth;
	private Map<Long, Long> countByPosition
	;
	public Map<Race, Long> getCountByRace() {
		return countByRace;
	}
	public void setCountByRace(Map<Race, Long> countByRace) {
		this.countByRace = countByRace;
	}
	public Map<Gender, Long> getCountByGender() {
		return countByGender;
	}
	public void setCountByGender(Map<Gender, Long> countByGender) {
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
	public Map<Long, Long> getCountByPosition() {
		return countByPosition;
	}
	public void setCountByPosition(Map<Long, Long> countByPosition) {
		this.countByPosition = countByPosition;
	}
	
	
}
