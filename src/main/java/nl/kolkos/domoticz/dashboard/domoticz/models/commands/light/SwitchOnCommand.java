package nl.kolkos.domoticz.dashboard.domoticz.models.commands.light;

import nl.kolkos.domoticz.dashboard.domoticz.entities.Switch;
import nl.kolkos.domoticz.dashboard.domoticz.models.commands.Command;

public class SwitchOnCommand implements Command {
    private Switch aSwitch;

    public SwitchOnCommand(Switch aSwitch) {
        this.aSwitch = aSwitch;
    }

    @Override
    public String execute() {
        return aSwitch.on();
    }
}
