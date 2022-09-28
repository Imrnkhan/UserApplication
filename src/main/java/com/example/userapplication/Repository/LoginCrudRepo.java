package com.example.userapplication.Repository;


import java.util.Optional;

import com.example.userapplication.Model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LoginCrudRepo extends JpaRepository<Login, Integer> {

    public Optional<Login> findByLoginId(Integer loginId);

    public Optional<Login> findByApiKey(String apiKey);
}
