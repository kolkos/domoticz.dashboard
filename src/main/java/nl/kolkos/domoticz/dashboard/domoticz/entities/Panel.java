package nl.kolkos.domoticz.dashboard.domoticz.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class Panel {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String safeName;

    @NotNull
    private String title;


//    @NotNull
//    @ManyToOne(fetch= FetchType.EAGER)
//    @JoinColumn(name = "device_id")
//    private Device device;

    private String icon;

}
