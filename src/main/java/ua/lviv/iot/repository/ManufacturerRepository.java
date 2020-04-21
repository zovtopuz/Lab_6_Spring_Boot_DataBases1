package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Manufacturer;

@Repository
public interface ManufacturerRepository  extends JpaRepository<Manufacturer, Integer> {
}