# spring-boot-mustache-lombok-demo #

[![Build Status](https://travis-ci.org/peterszatmary/spring-boot-mustache-lombok-demo.svg?branch=master)](https://travis-ci.org/peterszatmary/spring-boot-mustache-lombok-demo)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/f546ba46e3184e738150b8a79bd04204)](https://www.codacy.com/app/peterszatmary/spring-boot-mustache-lombok-demo?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=peterszatmary/spring-boot-mustache-lombok-demo&amp;utm_campaign=Badge_Grade)

Spring Boot demo with [Mustache](https://github.com/spullara/mustache.java) logic less templates integrated with [springmvc-mustache](https://github.com/mjeanroy/springmvc-mustache).
[Lombok](https://projectlombok.org/) is used for simplifing POJOs in project.

## How to run demo ##

```bash
mvn clean install
java -jar spring-boot-mustache-demo-0.0.1-SNAPSHOT.jar
go to localhost:8080
```

## How it works ##

### Config ###

Integrated with [springmvc-mustache](https://github.com/mjeanroy/springmvc-mustache). It is not standard way but very easy one.

```java
package com.szatmary.peter.mustache.demo.conf;

import com.github.mjeanroy.springmvc.view.mustache.configuration.EnableMustache;
import com.github.mjeanroy.springmvc.view.mustache.configuration.MustacheProvider;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableMustache(provider = MustacheProvider.AUTO)
@ComponentScan("com.szatmary.peter.mustache.demo")
public class MustacheConfig {
}
```

### Controler ###

```Map<String, Object> model``` is used implicitly on template site for rendering your java data from controller.

```java
package com.szatmary.peter.mustache.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;
import static com.szatmary.peter.mustache.demo.helper.DataHelper.*;

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
```

### Student object with Lombok ###

```java
package com.szatmary.peter.mustache.demo.obj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    private String name;
    private Integer age;
    private Address address;
}
```

### Address object with Lombok ###

```java
package com.szatmary.peter.mustache.demo.obj;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Address {
    private String address;
}
```

### Mustache template ###


```html
<!DOCTYPE html>
<html lang="en">
<body>
    <h1>Mustache.java + Spring Boot +  Lombok demo</h1>

    <h2>Render one object</h2>
    <strong>oneStudent name:</strong> {{oneStudent.name}}<br />
    <strong>oneStudent age:</strong> {{oneStudent.age}}<br />
    <strong>oneStudent address:</strong> {{oneStudent.address.address}}<br />

    <hr />

    <h2>Render two objects</h2>
    {{#twoStudents}}
        <strong>Name:</strong> {{name}}
        <strong>Age:</strong> {{age}}
        <strong>Address :</strong> {{address.address}}<br />
    {{/twoStudents}}
    <hr />

    <h2>Render with conditions</h2>

    {{#showIt}}
        Show it !
    {{/showIt}}

    {{#neverShowIt}}
        Never show it !
    {{/neverShowIt}}

    <br /><br />
    <hr />

    <h2>If nothing to render than what ?</h2>

    {{#noStudents}}
        <strong>Name:</strong> {{name}}
    {{/noStudents}}
    {{^noStudents}}
        No students here.
    {{/noStudents}}

    <hr />

    <h2>Empty list not rendering</h2>
    {{#emptyList}}
        <strong>Name:</strong> {{name}}<br />
    {{/emptyList}}
    </body>
</html>
```