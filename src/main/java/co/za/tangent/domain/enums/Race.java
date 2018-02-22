package co.za.tangent.domain.enums;

public enum Race implements FilterEnum {
	B("B", "Black African"),
	C("F","Coloured"),
	I("I","Indian or Asian"),
	W("W","White"),
	N("N","None Dominant");

	private String value;
	private String label;
	
	Race(String value, String label){
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
