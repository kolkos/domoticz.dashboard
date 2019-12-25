package nl.kolkos.domoticz.dashboard.domoticz.models.commands.dimmer;

import nl.kolkos.domoticz.dashboard.domoticz.entities.Dimmer;
import nl.kolkos.domoticz.dashboard.domoticz.models.commands.Command;

public class DimmerOffCommand implements Command {
    private Dimmer dimmer;

    public DimmerOffCommand(Dimmer dimmer) {
        this.dimmer = dimmer;
    }

    @Override
    public String execute() {
        return dimmer.off();
    }
}
