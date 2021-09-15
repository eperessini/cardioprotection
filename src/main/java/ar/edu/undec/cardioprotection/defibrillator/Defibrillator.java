package ar.edu.undec.cardioprotection.defibrillator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

import static java.lang.Boolean.TRUE;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class Defibrillator {
    @Id
    @SequenceGenerator(
            name= "defibrillator_sequence",
            sequenceName = "defibrillator_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "defibrillator_sequence"
    )
    private Long id;
    private Long serialNumber;
    private Date warrantyExpirationDate;
    private Date batteriesExpirationDate;
    private Date electrodesExpirationDate;
    double latitude;
    double longitude;
    private Boolean available = TRUE;

    public  Defibrillator(Long serialNumber,
                          Date warrantyExpirationDate,
                          Date batteriesExpirationDate,
                          Date electrodesExpirationDate,
                          double latitude,
                          double longitude){

        this.serialNumber = serialNumber;
        this.warrantyExpirationDate = warrantyExpirationDate;
        this.batteriesExpirationDate = batteriesExpirationDate;
        this.electrodesExpirationDate = electrodesExpirationDate;
        this.latitude = latitude;
        this.longitude = longitude;
        //this.available = TRUE;
    }
}
