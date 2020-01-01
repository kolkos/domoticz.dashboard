package nl.kolkos.domoticz.dashboard.domoticz.repositories;

import nl.kolkos.domoticz.dashboard.domoticz.entities.Heater;

import javax.transaction.Transactional;

@Transactional
public interface HeaterRepository extends DeviceRepository<Heater> {
}
