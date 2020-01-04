package nl.kolkos.domoticz.dashboard.domoticz.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import nl.kolkos.domoticz.dashboard.domoticz.models.PossibleActions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Switch extends Device{

    public String on() {
        return String.format("/json.htm?type=command&param=switchlight&idx=%d&switchcmd=On", this.gid);
    }

    public String off() {
        return String.format("/json.htm?type=command&param=switchlight&idx=%d&switchcmd=Off", this.gid);
    }

    @Override
    public String getStatus() {
        return String.format("/json.htm?type=devices&rid=%d", this.gid);
    }

    @Override
    public List<PossibleActions> getPossibleActions() {
        return Arrays.asList(PossibleActions.ON, PossibleActions.OFF, PossibleActions.GET_STATUS);
    }

    @Override
    public boolean filter(DeviceType deviceType) {
        return deviceType == DeviceType.SWITCH;
    }


}
