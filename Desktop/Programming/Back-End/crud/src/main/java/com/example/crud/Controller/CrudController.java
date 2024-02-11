package com.example.crud.Controller;

import com.example.crud.entity.User;
import com.example.crud.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class CrudController {

    @Autowired
    private CrudService crudService;

    @PostMapping("/get")
    public String Create(User user){
        crudService.write(user);

        return "ok";
    }

    @GetMapping("/read")
    public String Read(Model model){
        model.addAttribute("list", crudService.list());

        return "ok";
    }

    @DeleteMapping("/delete")
    public String Delete(Integer id){

        crudService.delete(id);
        return "ok";
    }

    @GetMapping("/update/{id}")
    public String Modify(@PathVariable("id") Integer id, Model model){

        model.addAttribute("User", crudService.update(id));
        return "ok";
    }

}
