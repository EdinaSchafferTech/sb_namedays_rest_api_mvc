package pti.sb_namedays_rest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("namedays")
public class Nameday {

	@Id
	@Column
	private int id;

	@Column("name")
	private String name;

	@Column("date")
	private String date;

	public Nameday() {
		super();
	}

	public Nameday(int id, String name, String date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
