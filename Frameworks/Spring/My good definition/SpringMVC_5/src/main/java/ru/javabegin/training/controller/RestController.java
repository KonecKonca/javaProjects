package ru.javabegin.training.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.javabegin.training.objects.User;

@Controller
@Slf4j
public class RestController {

    @RequestMapping(value = "/get-json-user", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User getJsonUser(@RequestParam("name") String name){
        User user = new User();
        user.setName(name);

        return user;
    }

    @RequestMapping(value = "/get-json-user/{name}/{password}/{isAdmin}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User getJsonUser(
            @PathVariable("name") String name,
            @PathVariable("password") String password,
            @PathVariable("isAdmin") boolean isAdmin
        ){

        return new User().builder().name(name).password(password).isAdmin(isAdmin).build();
    }

    @RequestMapping(value = "/put-json-user", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> setJsonUser(@RequestBody User user){
        log.info("username is: " + user.getName());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
