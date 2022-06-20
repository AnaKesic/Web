package web2022.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import web2022.dto.UserDTO;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User implements Serializable {

	private static final long serialVersionUID = -8207261429084622354L;

	private Long id;
	
	private boolean isDeleted;
	
	public User(UserDTO userDTO) {
		this.id = System.currentTimeMillis();
		this.isDeleted = false;
	}
	
}