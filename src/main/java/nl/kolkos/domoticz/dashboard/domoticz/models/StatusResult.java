package nl.kolkos.domoticz.dashboard.domoticz.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusResult {
    private String data;
    private String description;
    private int idx;
    private int level;
    private int levelInt;
    private String name;
    private String LastUpdate;
    private String status;

}
