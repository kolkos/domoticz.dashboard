package nl.kolkos.domoticz.dashboard.domoticz.models.commands.contact;

import nl.kolkos.domoticz.dashboard.domoticz.entities.Contact;
import nl.kolkos.domoticz.dashboard.domoticz.models.commands.Command;

public class ContactGetStatusCommand implements Command {

    private Contact contact;

    public ContactGetStatusCommand(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String execute() {
        return contact.getStatus();
    }
}
