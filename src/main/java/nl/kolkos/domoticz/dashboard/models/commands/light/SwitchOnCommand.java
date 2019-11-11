package nl.kolkos.domoticz.dashboard.models.commands.light;

import nl.kolkos.domoticz.dashboard.entities.Switch;
import nl.kolkos.domoticz.dashboard.models.commands.Command;

public class SwitchOnCommand implements Command {
    private Switch aSwitch;

    public SwitchOnCommand(Switch aSwitch) {
        this.aSwitch = aSwitch;
    }

    @Override
    public void execute() {
        aSwitch.on();
    }
}
