package com.irispr.data.models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

/**
 * Created by wendel.schultz on 9/18/15.
 */
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    @Type( type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime" )
    private ZonedDateTime creationDate;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    @Type( type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime" )
    private ZonedDateTime updatedDate;

    @Column
    private String name;

    @Column
    private String subdomain;

    @Column
    private Boolean active;

    @OneToMany(mappedBy = "account")
    private Set<User> users;

    @OneToMany(mappedBy = "account")
    private Set<Client> clients;
}
