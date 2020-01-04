package nl.kolkos.domoticz.dashboard.domoticz.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import nl.kolkos.domoticz.dashboard.domoticz.models.PossibleActions;

import javax.persistence.Entity;
import java.util.Collections;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Contact extends Device {


    @Override
    public boolean filter(DeviceType deviceType) {
        return deviceType == DeviceType.CONTACT;
    }

    @Override
    public String getStatus() {
        return String.format("/json.htm?type=devices&rid=%d", this.gid);
    }

    @Override
    public List<PossibleActions> getPossibleActions() {
        return Collections.singletonList(PossibleActions.GET_STATUS);
    }
}
