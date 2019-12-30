package nl.kolkos.domoticz.dashboard.domoticz.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Heater implements Device{

    @Id
    @GeneratedValue
    private long id;
    private int gid;
    private String name;


    public String setTemperature(double temperature) {
        return String.format("/json.htm?type=command&param=setsetpoint&idx=%d&setpoint=%.1f", this.gid, temperature);
    }

    @Override
    public String getStatus() {
        return String.format("/json.htm?type=devices&rid=%d", this.gid);
    }

    @Override
    public boolean filter(DeviceType deviceType) {
        return deviceType == DeviceType.HEATER;
    }
}
