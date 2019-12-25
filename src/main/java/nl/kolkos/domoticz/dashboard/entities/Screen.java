package nl.kolkos.domoticz.dashboard.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Screen {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String description;
    private String safeName;

    private int position;


}
