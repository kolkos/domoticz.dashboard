package nl.kolkos.domoticz.dashboard.domoticz.models.commands.light;

import nl.kolkos.domoticz.dashboard.domoticz.entities.Dimmer;
import nl.kolkos.domoticz.dashboard.domoticz.models.commands.Command;

public class SwitchGetStatusCommand implements Command {

    private Dimmer dimmer;

    public SwitchGetStatusCommand(Dimmer dimmer) {
        this.dimmer = dimmer;
    }

    @Override
    public String execute() {
        return dimmer.getStatus();
    }
}
