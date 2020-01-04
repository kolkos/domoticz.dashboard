package nl.kolkos.domoticz.dashboard.domoticz.entities;


import lombok.Data;
import nl.kolkos.domoticz.dashboard.domoticz.models.PossibleActions;

import javax.persistence.Entity;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
public class Scene extends Device {
    public String on() {
        return String.format("/json.htm?type=command&param=switchscene&idx=%d&switchcmd=On", this.gid);
    }

    @Override
    public String getStatus() {
        return String.format("/json.htm?type=scenes&rid=%d", this.gid);
    }

    @Override
    public List<PossibleActions> getPossibleActions() {
        return Arrays.asList(PossibleActions.ON, PossibleActions.GET_STATUS);
    }

    @Override
    public boolean filter(DeviceType deviceType) {
        return deviceType == DeviceType.SCENE;
    }
}
