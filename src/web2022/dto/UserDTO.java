package web2022.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import web2022.dto.UserDTO;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDTO {

	private Long id;
	
	private boolean isDeleted;
	
}