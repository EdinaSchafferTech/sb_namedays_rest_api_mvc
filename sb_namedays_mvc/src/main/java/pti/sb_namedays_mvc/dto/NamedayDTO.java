package pti.sb_namedays_mvc.dto;

public class NamedayDTO {

	private String name;
	private String date;

	public NamedayDTO() {
		super();
	}

	public NamedayDTO( String name, String date) {
		super();

		this.name = name;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
