package com.example.userapplication.Controller;



import com.example.userapplication.Model.Customer;
import com.example.userapplication.Model.UserDTO;
import com.example.userapplication.Services.LoginServiceInterface;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ecommerce/")
public class LoginController {

    @Autowired
    LoginServiceInterface loginServiceInterface;
    private LoginServiceInterface loginService;

    @PostMapping("login/{type}")
    public ResponseEntity<User> loginUser(@RequestBody UserDTO loginInfo, @PathVariable String type) {
        Customer loggedInUser = loginServiceInterface.login(loginInfo, type);
        return new ResponseEntity<User>((User) loggedInUser, HttpStatus.OK);
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logoutUser(@RequestParam String key) {
        String message = loginService.logout(key);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

}
