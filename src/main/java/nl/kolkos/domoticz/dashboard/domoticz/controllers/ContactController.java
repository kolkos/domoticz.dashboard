package nl.kolkos.domoticz.dashboard.domoticz.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nl.kolkos.domoticz.dashboard.domoticz.entities.Contact;
import nl.kolkos.domoticz.dashboard.domoticz.services.ContactService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/devices/contact")
@Log4j2
public class ContactController {
    private final ContactService contactService;

    @GetMapping("/listAll")
    public Iterable<Contact> findAll() {
        return contactService.findAll();
    }

    @GetMapping("/get/{gid}")
    public Contact getContactByGid(@PathVariable("gid") int gid) {
        return contactService.getByGid(gid);
    }


}
