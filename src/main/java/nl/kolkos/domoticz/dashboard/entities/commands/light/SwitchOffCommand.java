package nl.kolkos.domoticz.dashboard.entities.commands.light;

import nl.kolkos.domoticz.dashboard.entities.Switch;
import nl.kolkos.domoticz.dashboard.entities.commands.Command;

public class SwitchOffCommand implements Command {
    private Switch aSwitch;

    public SwitchOffCommand(Switch aSwitch) {
        this.aSwitch = aSwitch;
    }

    @Override
    public void execute() {
        aSwitch.off();
    }
}
