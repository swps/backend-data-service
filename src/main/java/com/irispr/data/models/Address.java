package com.irispr.data.models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * Created by wendel.schultz on 9/19/15.
 */
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    @Type( type = "org.jadira.usertype.dateandtime.threeten.PersistentInstantAsTimestamp" )
    private ZonedDateTime creationDate;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    @Type( type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime" )
    private ZonedDateTime updatedDate;


    @Column
    private String type;

    @Column
    private String street;

    @Column
    private String unit;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String postal;
}
