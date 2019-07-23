package com.mvc.boot.resources;

import com.mvc.boot.models.HelloModel;
import com.mvc.boot.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class HelloResource {

    @Autowired
    HelloService helloService;

    @RequestMapping("/hello")
    HelloModel hi() {
        return helloService.sayHello();
    }

    @RequestMapping("/bye")
    HelloModel bye() {
        return helloService.sayBye();
    }

}
