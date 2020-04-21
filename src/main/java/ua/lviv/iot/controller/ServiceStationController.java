package ua.lviv.iot.controller;
import ua.lviv.iot.service.ServiceService;
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
import ua.lviv.iot.domain.ServiceStation;

@RestController
@RequestMapping("/weather_station")
public class ServiceStationController {
    @Autowired
    ServiceService serviceService;

    @GetMapping("/service")
    public List<ServiceStation> findAll() throws Exception {
        return serviceService.findAll();
    }

    @GetMapping("/service/{id}")
    public ServiceStation findById(@PathVariable Integer id) throws Exception {
        return serviceService.findById(id);
    }

    @PostMapping("/service")
    public void create(@RequestBody ServiceStation entity) throws Exception {
        serviceService.create(entity);
    }

    @PutMapping("/service/{id}")
    public void update(@PathVariable Integer id, @RequestBody ServiceStation entity) throws Exception {
        entity.setId(id);
        serviceService.update(entity);
    }

    @DeleteMapping("/service/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        serviceService.delete(id);
    }
}
