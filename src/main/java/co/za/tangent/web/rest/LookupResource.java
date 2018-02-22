package co.za.tangent.web.rest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.za.tangent.domain.enums.Gender;
import co.za.tangent.domain.enums.Race;
import co.za.tangent.dto.FilterDTO;
import co.za.tangent.service.PositionService;

@RestController
@RequestMapping("/api/lookups")
public class LookupResource {
	@Autowired
	PositionService positionService;
	
	@GetMapping("/gender")
	List<FilterDTO> getGender(){
		return Arrays.asList(Gender.values()).stream().map(g->new FilterDTO(g)).collect(Collectors.toList());
	}
	
	@GetMapping("/position")
	List<FilterDTO> getPosition(){
		return positionService.getPositions().entrySet().stream().map(pe->new FilterDTO(pe.getValue())).collect(Collectors.toList());
	}
	
	@GetMapping("/race")
	List<FilterDTO> getRace(){
		return Arrays.asList(Race.values()).stream().map(r->new FilterDTO(r)).collect(Collectors.toList());
	}
	
}
