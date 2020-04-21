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
import ua.lviv.iot.domain.Station;
import ua.lviv.iot.service.StationService;

import java.util.List;

@RestController
@RequestMapping("/weather_station")
public class StationController {
    @Autowired
    StationService stationService;

    @GetMapping("/station")
    public List<Station> findAll() throws Exception {
        return stationService.findAll();
    }

    @GetMapping("/station/{id}")
    public Station findById(@PathVariable Integer id) throws Exception {
        return stationService.findById(id);
    }

    @PostMapping("/station")
    public void create(@RequestBody Station entity) throws Exception {
        stationService.create(entity);
    }

    @PutMapping("/station/{id}")
    public void update(@PathVariable Integer id, @RequestBody Station entity) throws Exception {
        entity.setIdstation(id);
        stationService.update(entity);
    }

    @DeleteMapping("/station/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        stationService.delete(id);
    }
}
