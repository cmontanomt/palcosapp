package com.usa.palcosapp.controller;

import com.usa.palcosapp.model.ClientModel;
import com.usa.palcosapp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins ="*",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.POST, RequestMethod.DELETE})
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<ClientModel> getAll(){
        return clientService.getAll();
    }
    @GetMapping("/{idClient}")
    public Optional<ClientModel> getById (@PathVariable("idClient") Integer id){
        return clientService.getById(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientModel save(@RequestBody ClientModel clientModel){
        return clientService.save(clientModel);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientModel update(@RequestBody ClientModel clientModel){
        return clientService.update(clientModel);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return clientService.delete(id);
    }
}
