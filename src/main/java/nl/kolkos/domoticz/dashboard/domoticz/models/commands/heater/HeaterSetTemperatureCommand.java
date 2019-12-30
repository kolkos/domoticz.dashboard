package nl.kolkos.domoticz.dashboard.domoticz.models.commands.heater;

import nl.kolkos.domoticz.dashboard.domoticz.entities.Heater;
import nl.kolkos.domoticz.dashboard.domoticz.models.commands.Command;

public class HeaterSetTemperatureCommand implements Command {
    private double temperature;
    private Heater heater;

    public HeaterSetTemperatureCommand(double temperature, Heater heater) {
        this.temperature = temperature;
        this.heater = heater;
    }

    @Override
    public String execute() {
        return heater.setTemperature(this.temperature);
    }
}
