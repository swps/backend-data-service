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
@Table(name = "contacts")
public class Contact {

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
    private String firstName;

    @Column
    private String lastName;

    @OneToOne
    @JoinColumn(name = "current_outlet_id")
    private Outlet currentOutlet;

    @ManyToMany
    @JoinTable(name = "contact_outlets",
               joinColumns = @JoinColumn(name = "contact_id"),
               inverseJoinColumns = @JoinColumn(name = "outlet_id")
    )
    private Set<Outlet> outlets;

    @OneToMany
    @JoinTable(name = "contact_tags",
            joinColumns = @JoinColumn(name = "contact_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags;

    @OneToMany(mappedBy = "contact")
    private Set<ContactChannel> channels;

}
