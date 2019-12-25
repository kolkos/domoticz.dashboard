package nl.kolkos.domoticz.dashboard.domoticz.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Level {
    private long percentage;
    private long levelToSet;
}
