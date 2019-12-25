package nl.kolkos.domoticz.dashboard.domoticz.models.commands.dimmer;

import nl.kolkos.domoticz.dashboard.domoticz.entities.Dimmer;
import nl.kolkos.domoticz.dashboard.domoticz.models.Level;
import nl.kolkos.domoticz.dashboard.domoticz.models.commands.Command;

public class DimmerSetLevelCommand implements Command {
    private Level level;
    private Dimmer dimmer;

    public DimmerSetLevelCommand(Level level, Dimmer dimmer) {
        this.level = level;
        this.dimmer = dimmer;
    }

    @Override
    public String execute() {
        return dimmer.setLevel(level);
    }
}
