package com.example.demo;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("demo")
public class DemoController {
    @Autowired DemoService service;

    @RequestMapping(method = RequestMethod.GET)
    public DemoEntity getDemo(@PathParam("id") Long id){
        return service.getReferenceById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createDemo(@RequestParam DemoEntity entity){
        service.save(entity);
    }

    @DeleteMapping
    public void deleteDemo(@PathParam("id") Long id){
        service.deleteById(id);
    }   
}
