package nl.kolkos.domoticz.dashboard.domoticz.entities;

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
