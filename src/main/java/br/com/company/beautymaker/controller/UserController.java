package br.com.company.beautymaker.controller;
//import br.com.company.beautymaker.model.User;
//import br.com.company.beautymaker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @GetMapping("/")
    public List<Object> getUsers() {
        return null;
    }


}