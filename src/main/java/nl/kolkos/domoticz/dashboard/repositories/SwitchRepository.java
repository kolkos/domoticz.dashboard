package nl.kolkos.domoticz.dashboard.repositories;

import nl.kolkos.domoticz.dashboard.entities.Switch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwitchRepository extends JpaRepository<Switch, Long> {
}
