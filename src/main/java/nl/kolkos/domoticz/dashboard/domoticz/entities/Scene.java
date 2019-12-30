package nl.kolkos.domoticz.dashboard.domoticz.entities;


import lombok.Data;

import javax.persistence.Entity;

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
    public boolean filter(DeviceType deviceType) {
        return deviceType == DeviceType.SCENE;
    }
}
