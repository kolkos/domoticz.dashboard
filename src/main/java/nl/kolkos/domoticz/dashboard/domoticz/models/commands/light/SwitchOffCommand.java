package nl.kolkos.domoticz.dashboard.domoticz.models.commands.light;

import nl.kolkos.domoticz.dashboard.domoticz.entities.Switch;
import nl.kolkos.domoticz.dashboard.domoticz.models.commands.Command;

public class SwitchOffCommand implements Command {
    private Switch aSwitch;

    public SwitchOffCommand(Switch aSwitch) {
        this.aSwitch = aSwitch;
    }

    @Override
    public String execute() {
        return aSwitch.off();
    }
}
