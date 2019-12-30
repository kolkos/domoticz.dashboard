package nl.kolkos.domoticz.dashboard.domoticz.models.commands.heater;

import nl.kolkos.domoticz.dashboard.domoticz.entities.Heater;
import nl.kolkos.domoticz.dashboard.domoticz.models.commands.Command;

public class HeaterGetStatusCommand implements Command {

    private Heater heater;

    public HeaterGetStatusCommand(Heater heater) {
        this.heater = heater;
    }

    @Override
    public String execute() {
        return heater.getStatus();
    }
}
