package nl.kolkos.domoticz.dashboard.domoticz.repositories;

import nl.kolkos.domoticz.dashboard.domoticz.entities.Scene;

import javax.transaction.Transactional;

@Transactional
public interface SceneRepository extends DeviceRepository<Scene> {
}
