package nl.kolkos.domoticz.dashboard.domoticz.entities;

public interface Device {
    int getGid();
    String getName();
    String getStatus();
    boolean filter(DeviceType deviceType);
}
