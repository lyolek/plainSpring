package org.sav.plainspring.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NamedQuery(name = "findAllUsers", query = "SELECT u FROM User u")
@NamedQuery(name = "findUsersByDepar", query = "SELECT u FROM User u WHERE u.depar = :depar")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("Id")
	private int id;

//	@Column(name = "name")
	@JsonProperty("Name")
	private String name;

//	@Column(name = "surname")
	@JsonProperty("Surname")
	private String surname;

//	@Column(name = "b_day")
	@JsonProperty("DBay")
	private LocalDate birthDate;
//	@Column(name = "deparId")
//	private int deparId;

	@ManyToOne
//	@JoinColumn(name = "depar_id")
	private Depar depar;
}