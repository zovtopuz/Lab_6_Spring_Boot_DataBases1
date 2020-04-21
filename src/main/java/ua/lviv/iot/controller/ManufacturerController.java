package ua.lviv.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import ua.lviv.iot.domain.Manufacturer;
import ua.lviv.iot.service.ManufacturerService;

@RestController
@RequestMapping("/weather_station")
public class ManufacturerController {
    @Autowired
    ManufacturerService manufacturerService;

    @GetMapping(value = "/manufacturer")
    public List<Manufacturer> findAll() throws Exception {
        return manufacturerService.findAll();
    }

    @GetMapping(value = "/manufacturer/{id}")
    public Manufacturer findById(@PathVariable Integer id) throws Exception {
        return manufacturerService.findById(id);
    }

    @PostMapping(value = "/manufacturer")
    public void create(@RequestBody Manufacturer entity) throws Exception {
        manufacturerService.create(entity);
    }

    @PutMapping(value = "/manufacturer/{id}")
    public void update(@PathVariable Integer id, @RequestBody Manufacturer entity) throws Exception {
        entity.setId(id);
        manufacturerService.update(entity);
    }

    @DeleteMapping(value = "/manufacturer/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        manufacturerService.delete(id);
    }
}
