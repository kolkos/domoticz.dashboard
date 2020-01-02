package nl.kolkos.domoticz.dashboard.domoticz.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
public class Contact extends Device {


    @Override
    boolean filter(DeviceType deviceType) {
        return deviceType == DeviceType.CONTACT;
    }

    @Override
    public String getStatus() {
        return String.format("/json.htm?type=devices&rid=%d", this.gid);
    }
}
