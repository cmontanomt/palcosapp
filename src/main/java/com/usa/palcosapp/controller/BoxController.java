package com.usa.palcosapp.controller;

import com.usa.palcosapp.model.BoxModel;
import com.usa.palcosapp.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Box")
@CrossOrigin(origins ="*",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.POST, RequestMethod.DELETE})
public class BoxController {
    @Autowired
    private BoxService boxService;

    @GetMapping("/all")
    public List<BoxModel> getAll(){
        return boxService.getAll();
    }
    @GetMapping("/{idBox}")
    public Optional<BoxModel> getById (@PathVariable("idBox") Integer id){
        return boxService.getById(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public BoxModel save(@RequestBody BoxModel boxModel){
        return boxService.save(boxModel);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public BoxModel update(@RequestBody BoxModel boxModel){
        return boxService.update(boxModel);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return boxService.delete(id);
    }
}
