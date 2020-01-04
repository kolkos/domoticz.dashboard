package nl.kolkos.domoticz.dashboard.domoticz.entities;

import lombok.Data;
import nl.kolkos.domoticz.dashboard.domoticz.models.PossibleActions;

import javax.persistence.Entity;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
public class Heater extends Device {

    public String setTemperature(double temperature) {
        return String.format("/json.htm?type=command&param=setsetpoint&idx=%d&setpoint=%.1f", this.gid, temperature);
    }

    @Override
    public String getStatus() {
        return String.format("/json.htm?type=devices&rid=%d", this.gid);
    }

    @Override
    public List<PossibleActions> getPossibleActions() {
        return Arrays.asList(PossibleActions.SET_TEMPERATURE, PossibleActions.GET_STATUS);
    }

    @Override
    public boolean filter(DeviceType deviceType) {
        return deviceType == DeviceType.HEATER;
    }
}
