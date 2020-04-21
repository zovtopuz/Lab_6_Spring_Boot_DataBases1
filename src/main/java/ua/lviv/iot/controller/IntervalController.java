//package ua.lviv.iot.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.Link;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import ua.lviv.iot.DTO.IntervalDTO;
//import ua.lviv.iot.domain.Interval;
//
//import ua.lviv.iot.service.IntervalService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
//
//@RestController
//public class IntervalController {
//    @Autowired
//    private IntervalService intervalService;
//
//   
//    @GetMapping(value = "/api/interval")
//    public ResponseEntity<List<IntervalDTO>> getAllIntervals() throws Exception {
//        List<Interval> intervalList = intervalService.getAllInterval();//////////
//        Link link = linkTo(methodOn(IntervalController.class).getAllInterval()).withSelfRel();
//        List<IntervalDTO> intervalDTO = new ArrayList<>();
//        for (Interval entity : intervalList) {
//            Link selfLink = new Link(link.getHref() + "/" + entity.getId()).withSelfRel();
//            IntervalDTO dto = new IntervalDTO(entity, selfLink);
//            intervalDTO.add(dto);
//        }
//        return new ResponseEntity<>(intervalDTO, HttpStatus.OK);
//    }
//    
//    
//    
//    
//    @GetMapping(value = "/api/interval/{idinterval}")
//    public ResponseEntity<IntervalDTO> getIntervalById(@PathVariable Integer idinterval) throws Exception {
//        Interval interval = intervalService.getInterval(idinterval);
//        Link link = linkTo(methodOn(IntervalController.class).getInterval(idinterval)).withSelfRel();
//        IntervalDTO intervalDTO = new IntervalDTO(interval, link);
//        return new ResponseEntity<>(intervalDTO, HttpStatus.OK);
//    }
//
//    @PostMapping(value = "/api/interval/{idinterval}")
//    public ResponseEntity<IntervalDTO> addInterval(@RequestBody Interval newInterval) throws Exception {
//        intervalService.createInterval(newInterval);
//        Link link = linkTo(methodOn(IntervalController.class).getCity(newInterval.getId())).withSelfRel();//
//        IntervalDTO intervalDTO = new IntervalDTO(newInterval, link);
//        return new ResponseEntity<>(intervalDTO, HttpStatus.CREATED);
//    }
//
//    @PutMapping(value = "/api/interval/{idinterval}")
//    public ResponseEntity<IntervalDTO> updateInterval(@RequestBody Interval interval, @PathVariable Integer idinterval) throws Exception {
//        intervalService.updateInterval(interval, idinterval);
//        Interval interval = intervalService.getInterval(idinterval);
//        Link link = linkTo(methodOn(IntervalController.class).getInterval(idinterval)).withSelfRel();
//        IntervalDTO intervalDTO = new IntervalDTO(interval, link);
//        return new ResponseEntity<>(intervalDTO, HttpStatus.OK);
//    }
//
//    @DeleteMapping(value = "/api/interval/{idinterval}")
//    public ResponseEntity deleteInterval(@PathVariable Integer idinterval) throws Exception {
//        intervalService.deleteInterval(idinterval);
//        return new ResponseEntity(HttpStatus.OK);
//    }
//}

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
import ua.lviv.iot.domain.Interval;
import ua.lviv.iot.service.IntervalService;

@RestController
@RequestMapping("/weather_station")
public class IntervalController {
    @Autowired
    IntervalService intervalService;

    @GetMapping(value = "/interval")
    public List<Interval> findAll() throws Exception {
        return intervalService.findAll();
    }

    @GetMapping(value = "/interval/{id}")
    public Interval findById(@PathVariable Integer id) throws Exception {
        return intervalService.findById(id);
    }

    @PostMapping(value = "/interval")
    public void create(@RequestBody Interval entity) throws Exception {
        intervalService.create(entity);
    }

    @PutMapping(value = "/interval/{id}")
    public void update(@PathVariable Integer id, @RequestBody Interval entity) throws Exception {
        entity.setIdinterval(id);
        intervalService.update(entity);
    }

    @DeleteMapping(value = "/interval/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        intervalService.delete(id);
    }
}
