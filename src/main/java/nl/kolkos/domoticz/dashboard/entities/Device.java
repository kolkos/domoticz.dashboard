package nl.kolkos.domoticz.dashboard.entities;

public interface Device {
    int getGid();
    String getName();
    boolean filter(DeviceType deviceType);
}
