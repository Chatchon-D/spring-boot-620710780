package com.training.platform.controllers;

import com.training.platform.entities.User;
import com.training.platform.repositories.UserRepository;
import com.training.platform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/demo2")

public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserService userRepository;

    /*@GetMapping(value = "")
    public List<User> index() throws Exception {
        return userService.findAll();
    }*/
    @GetMapping(value = "")
    public List<User> index() {

        return userService.findAll();
    }

    @GetMapping(value = "/t2")

    public Optional<User> findById(@RequestParam String id){
        return userService.findById(Integer.parseInt(id));
    }

    @GetMapping(value = "/t3")
    public Page<User> findAllByLimit(@RequestParam String start, @RequestParam String limit,@RequestParam String field){
        return userService.findAllByLimit(Integer.parseInt(start),Integer.parseInt(limit),field);
    }

    @GetMapping(value = "/t4/{city}/{active}/{age}")
    public List<User> findByCityAndActiveAndAge(@PathVariable String city,@PathVariable String active,@PathVariable String age) {
        return userService.findByCityAndActiveAndAge(city,Integer.parseInt(active),Integer.parseInt(age));
    }

    @GetMapping(value = "/t5")
    public List<User> findByAgeIn(@RequestParam List<Integer> age ){
        return userService.findByAgeIn(age);
    }

    @GetMapping(value = "/t6")
    public List<User> findAllByQuery(){
        return userService.findAllByQuery();
    }

    @GetMapping(value = "/t7")
    public List<User> findAllByParamsQuery(@RequestParam String active,@RequestParam String city){
        return userService.findAllByParamsQuery(Integer.parseInt(active),city);
    }

    @GetMapping(value = "/t8")
    public List<User> findAllByJpqlQuery(){
        return userService.findAllByJpqlQuery();
    }

    @GetMapping(value = "/t9")
    public List<User> findAllByJpqlParamsQuery(@RequestParam Integer active,@RequestParam String city){
        return userService.findAllByJpqlParamsQuery(active,city);
    }

    @GetMapping(value = "/t10")
    public List<User> findByCity(@RequestParam String city){
        return userService.findByCity(city);
    }

    @GetMapping(value = "/t11")
    List<User> findByName(String name){
        return userRepository.findByName(name);
    }
}
