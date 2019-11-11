package nl.kolkos.domoticz.dashboard.repositories;

import nl.kolkos.domoticz.dashboard.entities.Dimmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DimmerRepository extends JpaRepository<Dimmer, Long> {
}
