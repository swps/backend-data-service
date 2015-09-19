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
@Table(name = "activities")
public class Activity {

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
    private String name;

    @Column
    private String type;

    // ref id?
    // ref name?

    @OneToOne
    @JoinColumn(name = "contact_id")
    private Contact client;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User createdBy;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
