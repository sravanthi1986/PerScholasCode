package com.perscholas.snacks_repository.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Student {
	@Id
	@GeneratedValue
	private Integer snacksid;

	@Size(min = 2, max = 50, message = "Title must be between 2 and 50 characters long.")
	@NotBlank(message = "snacksname is required.")
	private String snacksname;

	@Size(min = 2, max = 50, message = "Author name must be between 2 and 50 characters long.")
	@NotBlank(message = "student name is required.")
	private String studentname;

}
