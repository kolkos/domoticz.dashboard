package nl.kolkos.domoticz.dashboard.models.commands.dimmer;

import nl.kolkos.domoticz.dashboard.entities.Dimmer;
import nl.kolkos.domoticz.dashboard.models.commands.Command;

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
