package org.sav.plainspring.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@NamedQuery(name = "findAllDepars", query = "SELECT d FROM Depar d")
public class Depar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("Id")
	private int id;

//	@Column(name = "Name")
	@JsonProperty("Name")
	private String name;

	public String getName() {
		return name;
	}

	@JsonProperty("ParId")
//	@Column(name = "par_id")
	private int parId;


//	@OneToMany(mappedBy = "deparId", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
//	private List<User> users;
}
