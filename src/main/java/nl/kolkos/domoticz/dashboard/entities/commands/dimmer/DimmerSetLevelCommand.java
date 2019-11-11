package nl.kolkos.domoticz.dashboard.entities.commands.dimmer;

import nl.kolkos.domoticz.dashboard.entities.Dimmer;
import nl.kolkos.domoticz.dashboard.entities.Level;
import nl.kolkos.domoticz.dashboard.entities.commands.Command;

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
