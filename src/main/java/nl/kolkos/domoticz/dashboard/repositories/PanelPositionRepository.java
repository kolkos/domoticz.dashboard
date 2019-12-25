package nl.kolkos.domoticz.dashboard.repositories;

import nl.kolkos.domoticz.dashboard.entities.PanelPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanelPositionRepository extends JpaRepository<PanelPosition, Long> {
}
