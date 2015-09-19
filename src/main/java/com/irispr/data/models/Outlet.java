package com.irispr.data.models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

/**
 * Created by wendel.schultz on 9/19/15.
 */
@Entity
@Table(name = "outlets")
public class Outlet {

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
    private String position;

    @Column
    private String email;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;


    @OneToMany
    @JoinTable(name = "outlet_addresses",
            joinColumns = @JoinColumn(name = "contact_id"),
            inverseJoinColumns = @JoinColumn(name = "outlet_id")
    )
    private Set<Address> addresses;

    @OneToMany
    @JoinTable(name = "user_phones",
            joinColumns = @JoinColumn(name = "outlet_id"),
            inverseJoinColumns = @JoinColumn(name = "phone_id")
    )
    private Set<Phone> phones;
}
