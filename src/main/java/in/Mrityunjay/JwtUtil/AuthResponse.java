package in.Mrityunjay.JwtUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Sends JWT token back to the client.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private String token;

}
