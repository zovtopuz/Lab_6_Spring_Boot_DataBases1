package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Station;

@Repository
public interface StationRepository  extends JpaRepository<Station, Integer> {
}