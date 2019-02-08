package ru.javabegin.training.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {
	@Size(min = 3, message = "{name.size.error}")
	private String name;
	@Size(min = 5, max = 20, message = "{password.size.error}")
	private String password;
	private boolean isAdmin;
}
