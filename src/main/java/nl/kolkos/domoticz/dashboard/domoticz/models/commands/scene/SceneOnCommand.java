package nl.kolkos.domoticz.dashboard.domoticz.models.commands.scene;

import nl.kolkos.domoticz.dashboard.domoticz.entities.Scene;
import nl.kolkos.domoticz.dashboard.domoticz.models.commands.Command;

public class SceneOnCommand implements Command {
    private Scene scene;

    public SceneOnCommand(Scene scene) {
        this.scene = scene;
    }

    @Override
    public String execute() {
        return scene.on();
    }
}
