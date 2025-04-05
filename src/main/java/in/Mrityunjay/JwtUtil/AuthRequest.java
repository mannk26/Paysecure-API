package in.Mrityunjay.JwtUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Captures login details (username & password)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
	    private String email;
	    private String password;

}
