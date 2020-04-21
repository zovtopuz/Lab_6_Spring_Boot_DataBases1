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
import ua.lviv.iot.domain.Weather;
import ua.lviv.iot.service.WeatherService;

@RestController
@RequestMapping("/weather_station")
public class WeatherController {
    @Autowired
    WeatherService weatherService;

    @GetMapping("/weather")
    public List<Weather> findAll() throws Exception {
        return weatherService.findAll();
    }

    @GetMapping("/weather/{id}")
    public Weather findById(@PathVariable Integer id) throws Exception {
        return weatherService.findById(id);
    }

    @PostMapping("/weather")
    public void create(@RequestBody Weather entity) throws Exception {
        weatherService.create(entity);
    }

    @PutMapping("/weather/{id}")
    public void update(@PathVariable Integer id, @RequestBody Weather entity) throws Exception {
        entity.setId(id);
        weatherService.update(entity);
    }

    @DeleteMapping("/weather/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        weatherService.delete(id);
    }
}
