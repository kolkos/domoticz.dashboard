package nl.kolkos.domoticz.dashboard.dashboard.repositories;

import nl.kolkos.domoticz.dashboard.dashboard.entities.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Long> {
}
