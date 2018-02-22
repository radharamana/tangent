package co.za.tangent.domain.enums;

public enum Gender implements FilterEnum {
	M("M", "Male"),F("F","Female");
	
	private String value;
	private String label;
	
	Gender(String value, String label){
		this.value = value;
		this.label = label;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String getLabel() {
		return label;
	}
	
	
	
}
