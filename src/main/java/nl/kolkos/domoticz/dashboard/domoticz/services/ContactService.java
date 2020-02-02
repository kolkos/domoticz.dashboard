package nl.kolkos.domoticz.dashboard.domoticz.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nl.kolkos.domoticz.dashboard.domoticz.entities.Contact;
import nl.kolkos.domoticz.dashboard.domoticz.exceptions.DeviceNotFoundException;
import nl.kolkos.domoticz.dashboard.domoticz.models.StatusResult;
import nl.kolkos.domoticz.dashboard.domoticz.repositories.ContactRepository;
import nl.kolkos.domoticz.dashboard.domoticz.util.Constants;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class ContactService {
    private final ContactRepository contactRepository;

    public Contact save(Contact contact) {
        log.info("Saving contact to the database: {}", contact);
        return contactRepository.save(contact);
    }

    public Contact createContact(StatusResult statusResult) {
        Contact contact = new Contact();
        contact.setName(statusResult.getName());
        contact.setGid(statusResult.getIdx());
        return this.save(contact);
    }

    public Iterable<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Contact getByGid(int gid) throws DeviceNotFoundException {
        String errorMessage = String.format(Constants.DEVICE_NOT_FOUND_ERROR_MESSAGE_TEMPLATE, "Contact", gid);
        return contactRepository.getByGid(gid).orElseThrow(() -> new DeviceNotFoundException(errorMessage));
    }

}
