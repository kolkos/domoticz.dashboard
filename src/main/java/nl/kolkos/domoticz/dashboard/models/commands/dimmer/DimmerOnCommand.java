package nl.kolkos.domoticz.dashboard.models.commands.dimmer;

import nl.kolkos.domoticz.dashboard.entities.Dimmer;
import nl.kolkos.domoticz.dashboard.models.commands.Command;

public class DimmerOnCommand implements Command {
    private Dimmer dimmer;

    public DimmerOnCommand(Dimmer dimmer) {
        this.dimmer = dimmer;
    }

    @Override
    public String execute() {
        return dimmer.on();
    }
}
