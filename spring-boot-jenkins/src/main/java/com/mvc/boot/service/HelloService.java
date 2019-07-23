package com.mvc.boot.service;

import com.google.common.collect.Lists;
import com.mvc.boot.models.HelloModel;
import com.mvc.boot.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HelloService {

    HelloRepository helloRepository;

    @Autowired
    public HelloModel sayHello() {

        HelloModel helloModel = new HelloModel();
        helloModel.setGreeting("Hello");;

        return helloModel;
    }

    @Autowired
    public HelloModel sayBye() {

        HelloModel helloModel = new HelloModel();
        helloModel.setGreeting("Bye");
        helloModel.setBye(true);

        return helloModel;
    }

}
