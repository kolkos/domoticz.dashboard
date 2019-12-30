package nl.kolkos.domoticz.dashboard.domoticz.models.commands.scene;

import nl.kolkos.domoticz.dashboard.domoticz.entities.Scene;
import nl.kolkos.domoticz.dashboard.domoticz.models.commands.Command;

public class SceneGetStatusCommand implements Command {

    private Scene scene;

    public SceneGetStatusCommand(Scene scene) {
        this.scene = scene;
    }

    @Override
    public String execute() {
        return scene.getStatus();
    }
}
