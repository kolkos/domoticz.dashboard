package nl.kolkos.domoticz.dashboard.domoticz.services;

import lombok.RequiredArgsConstructor;
import nl.kolkos.domoticz.dashboard.domoticz.entities.Contact;
import nl.kolkos.domoticz.dashboard.domoticz.repositories.ContactRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;

    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    public Iterable<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Contact getByGid(int gid) {
        Contact contact = contactRepository.getByGid(gid);

        return null;
    }

}
