# spring-demo

Spring Web App Demo MVC Model View Controller


## Dependencies:  
**spring-boot-starter-data-jpa**  
**spring-boot-starter-thymeleaf**  
**spring-boot-starter-web**  
**mysql-connector-j**  

## Database Schema
![database-schema](https://github.com/MadForLife/spring-demo/assets/35624178/193db42d-1724-4e80-9177-8bdbceae7e82)

## Views
![html-view](https://github.com/MadForLife/spring-demo/assets/35624178/1eeababb-20c7-448f-bbbb-323122f40133)

## Minions Controller

```java
package com.spring.controller;

import com.spring.model.Minion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.spring.service.MinionService;

import java.util.List;

@Controller
@RequestMapping("/minions")
public class MinionController {
    private MinionService minionService;

    @Autowired
    public MinionController(MinionService minionService) {
        this.minionService = minionService;
    }

    @GetMapping("/all")
    public String getAllMinions(Model model) {
        List<Minion> minionList = minionService.findAll();
        model.addAttribute("minions", minionList);
        return "minions";
    }

}

```

## List of Minions View
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>List of Minions</title>
</head>
<body>
<h1>List of Minions</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
    </tr>
    </thead>
    <tbody>
    <tr th:each="minion : ${minions}">
        <td th:text="${minion.id}"></td>
        <td th:text="${minion.name}"></td>
        <td th:text="${minion.age}"></td>
    </tr>
    </tbody>
</table>
</body>
</html>
```


