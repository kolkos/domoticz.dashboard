package nl.kolkos.domoticz.dashboard.domoticz.repositories;

import nl.kolkos.domoticz.dashboard.domoticz.entities.Contact;

import javax.transaction.Transactional;

@Transactional
public interface ContactRepository extends DeviceRepository<Contact> {
}
