package nl.kolkos.domoticz.dashboard.models;

import nl.kolkos.domoticz.dashboard.models.commands.Command;

public class CommandRunner {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void run() {
        command.execute();
    }

}
