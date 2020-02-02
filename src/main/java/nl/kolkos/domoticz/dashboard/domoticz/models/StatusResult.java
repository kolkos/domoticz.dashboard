package nl.kolkos.domoticz.dashboard.domoticz.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusResult {

    @SerializedName(value = "Data")
    private String data;

    @SerializedName(value = "Description")
    private String description;

    @SerializedName(value = "idx")
    private int idx;

    @SerializedName(value = "Level")
    private int level;

    @SerializedName(value = "LevelInt")
    private int levelInt;

    @SerializedName(value = "SetPoint")
    private String setPoint;

    @SerializedName(value = "Name")
    private String name;

    @SerializedName(value = "LastUpdate")
    private String lastUpdate;

    @SerializedName(value = "Status")
    private String status;

    @SerializedName(value = "SwitchType")
    private String switchType;

    @SerializedName(value = "Type")
    private String type;

    @SerializedName(value = "MaxDimLevel")
    private int maxDimLevel;

}
