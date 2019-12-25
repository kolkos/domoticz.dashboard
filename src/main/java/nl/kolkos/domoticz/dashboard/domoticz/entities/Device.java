package nl.kolkos.domoticz.dashboard.domoticz.entities;

public interface Device {
    int getGid();
    String getName();
    boolean filter(DeviceType deviceType);
}
