package co.za.tangent.dto;

import co.za.tangent.domain.enums.FilterEnum;

public class FilterDTO implements FilterEnum{
	private String value;
	private String label;
	
	public FilterDTO(FilterEnum filterEnum){
		this.value = filterEnum.getValue();
		this.label = filterEnum.getLabel();
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	
	
}
