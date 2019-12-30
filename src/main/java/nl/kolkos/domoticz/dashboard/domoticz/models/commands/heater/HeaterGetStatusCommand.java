package nl.kolkos.domoticz.dashboard.domoticz.models.commands.heater;

import nl.kolkos.domoticz.dashboard.domoticz.entities.Dimmer;
import nl.kolkos.domoticz.dashboard.domoticz.models.commands.Command;

public class HeaterGetStatusCommand implements Command {

    private Dimmer dimmer;

    public HeaterGetStatusCommand(Dimmer dimmer) {
        this.dimmer = dimmer;
    }

    @Override
    public String execute() {
        return dimmer.getStatus();
    }
}
