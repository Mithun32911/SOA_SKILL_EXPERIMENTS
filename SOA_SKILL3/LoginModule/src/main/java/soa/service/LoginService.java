package soa.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import soa.model.Login;

@Service
public class LoginService {

    private final JwtService jwtService;

    public LoginService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public Map<String, Object> login(Login login) {
        Map<String, Object> response = new HashMap<>();
        try {
            RestClient client = RestClient.create();
            String url = "http://localhost:8000/gateway/signup/" + login.getUsername();
            System.out.println("Calling: " + url);

            SignupResponse signup = client.get()
                    .uri(url)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .body(SignupResponse.class);

            // ✅ Check user existence
            if (signup == null || signup.getCode() != 200) {
                response.put("code", signup != null ? signup.getCode() : 404);
                response.put("message", signup != null ? signup.getMessage() : "User not found");
                return response;
            }

            // ✅ Check password
            if (signup.getPassword() == null ||
                !signup.getPassword().equals(login.getPassword())) {
                response.put("code", 401);
                response.put("message", "Invalid password");
                return response;
            }

            // ✅ Generate JWT
            String token = jwtService.generateToken(login.getUsername());

            response.put("code", 200);
            response.put("status", "Login Successful");
            response.put("username", login.getUsername());
            response.put("token", token);

        } catch (Exception e) {
            response.put("code", 500);
            response.put("message", "Login Error: " + e.getMessage());
        }
        return response;
    }
}

class SignupResponse{
	int code;
	String username;
	String password;
	String emai;
	String message;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmai() {
		return emai;
	}
	public void setEmai(String emai) {
		this.emai = emai;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}


