package nl.kolkos.domoticz.dashboard.dashboard.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Data
@Entity
@NoArgsConstructor
public class PanelPosition {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "panel_id")
    private Panel panel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "screen_id")
    private Screen screen;

    // positional elements
    private int rowStart;      // the row where the panel starts
    private int columnStart;   // the column where the panel starts
    private int height;   // the height (in rows) of this panel
    private int width;    // the width (in columns) of this panel

    private boolean showTitle;
    private boolean showIcon;
    private boolean showData;


}
