package nl.kolkos.domoticz.dashboard.domoticz.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Scene implements Device {
    @Id
    @GeneratedValue
    private long id;
    private int gid;
    private String name;

    public String on() {
        return String.format("/json.htm?type=command&param=switchscene&idx=%d&switchcmd=On", this.gid);
    }

    @Override
    public boolean filter(DeviceType deviceType) {
        return deviceType == DeviceType.SCENE;
    }
}
