package nl.kolkos.domoticz.dashboard.models.commands.dimmer;

import nl.kolkos.domoticz.dashboard.entities.Dimmer;
import nl.kolkos.domoticz.dashboard.models.Level;
import nl.kolkos.domoticz.dashboard.models.commands.Command;

public class DimmerSetLevelCommand implements Command {
    private Level level;
    private Dimmer dimmer;

    public DimmerSetLevelCommand(Level level, Dimmer dimmer) {
        this.level = level;
        this.dimmer = dimmer;
    }

    @Override
    public void execute() {
        dimmer.setLvel(level);
    }
}
