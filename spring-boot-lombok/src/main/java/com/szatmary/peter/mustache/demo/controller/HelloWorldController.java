package com.szatmary.peter.mustache.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

import static com.szatmary.peter.mustache.demo.helper.DataHelper.*;

/**
 * Created by nue on 14.6.2016.
 */
@Controller
public class HelloWorldController {

    @RequestMapping("/")
    public String mustacheDemo(Map<String, Object> model) {

        // one object
        model.put("oneStudent", oneStudent());
        // two objects
        model.put("twoStudents", twoStudents());
        // condition
        model.put("showIt", true);
        // condition
        model.put("neverShowIt", false);
        // no students
        model.put("noStudents", noStudents());
        // emptyList
        model.put("emptyList", emptyList());

        return "demo/helloworld";
    }

}
