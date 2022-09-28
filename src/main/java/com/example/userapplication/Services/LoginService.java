package com.example.userapplication.Services;



import java.time.LocalDateTime;
import java.util.Optional;

import com.example.userapplication.Excepction.CustomerNotFoundException;
import com.example.userapplication.Excepction.InvalidLoginKeyException;
import com.example.userapplication.Excepction.LoginFailedException;
import com.example.userapplication.Model.Customer;
import com.example.userapplication.Model.Login;
import com.example.userapplication.Model.LoginStatus;
import com.example.userapplication.Model.UserDTO;
import com.example.userapplication.Repository.LoginCrudRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService implements LoginServiceInterface {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private LoginCrudRepo loginRepo;
    private CustomerService sellerService;

    @Override
    public Customer login(UserDTO loginInfo, String userType) {
        if(userType.equalsIgnoreCase("customer")) {
            try {
                Customer customer = customerService.findByUsernameAndPassword(loginInfo.getUserName(), loginInfo.getUserPassword());

                Login newLogin = null;

                if(customer.getLogin() == null) {
                    newLogin = new Login();
                } else {
                    newLogin = customer.getLogin();
                    newLogin.newLogin();
                }

                loginRepo.save(newLogin);
                newLogin.setUser((User) customer);
                return customerService.persistCustomer(customer.getUserId(), newLogin);

            } catch (CustomerNotFoundException error) {
                throw new LoginFailedException(error.getMessage());
            }
        } else if (userType.equalsIgnoreCase("seller")) {
            //TODO COLLOBORATE WITH DHANA
            try {
                Customer seller = sellerService.findByUsernameAndPassword(loginInfo.getUserName(), loginInfo.getUserPassword());

                Login newLogin = null;

                if(seller.getLogin() == null) {
                    newLogin = new Login();
                } else {
                    newLogin = seller.getLogin();
                    newLogin.newLogin();
                }

                loginRepo.save(newLogin);
                newLogin.setUser((User) seller);
                return sellerService.persistSeller(seller.getUsername(), newLogin);

            } catch (CustomerNotFoundException error) {
                throw new LoginFailedException(error.getMessage());
            }



        } else {
            throw new LoginFailedException("Mention the correct path. Only ecommerce/login/customer and ecommerce/login/seller is allowed.");
        }
    }


    //Method to logout user
    public String logout(String key) {

        //Getting the Login object using the key
        Optional<Login> opt = loginRepo.findByApiKey(key);

        if(opt.isPresent()) {

            //Getting the login object
            Login currentLogin = opt.get();

            //If the status is already logged_out we return
            if(currentLogin.getStatus() == LoginStatus.LOGGED_OUT) {
                return "User is already logged out";
            }

            //Calling the revoke login function as request by the user
            currentLogin.revokeLogin();

            //Persisting in the database
            loginRepo.save(currentLogin);
        } else {
            //Exception thrown if the key is not existing in the database
            throw new InvalidLoginKeyException("Invalid Login Key!");
        }

        //Message for successfull logout
        return "User logged out successfully!";
    }

    @Override
    public Login isTokenValid(String apiKey) {

        Optional<Login> opt = loginRepo.findByApiKey(apiKey);

        if(opt.isPresent()) {

            Login currentLogin = opt.get();

            LocalDateTime expiry = currentLogin.getKeyExpiryDate();

            if(currentLogin.getStatus() == LoginStatus.LOGGED_IN && LocalDateTime.now().isBefore(expiry)) {
                return currentLogin;
            } else {

                currentLogin.revokeLogin();
                loginRepo.save(currentLogin);
                throw new InvalidLoginKeyException("Login Key has expired please login again to generate a new key!");
            }

        } else {
            throw new InvalidLoginKeyException("Invalid Login Key!");
        }
    }

}


//    @Override
//    public User login(UserDTO userInfo, String UserType) {
//        return null;
//    }
//
//    @Override
//    public Login isTokenValid(String token) {
//        return null;
//    }
//
//    @Override
//    public String logout(String key) {
//        return null;
//    }
//}
