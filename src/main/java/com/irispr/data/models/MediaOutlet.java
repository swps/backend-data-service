package com.irispr.data.models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

/**
 * Created by wendel.schultz on 9/19/15.
 */
@Entity
@Table(name = "outlets")
public class MediaOutlet {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    @Type( type = "org.jadira.usertype.dateandtime.threeten.PersistentInstantAsTimestamp" )
    @CreatedDate
    private ZonedDateTime creationDate;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    @Type( type = "org.jadira.usertype.dateandtime.threeten.PersistentZonedDateTime" )
    @LastModifiedDate
    private ZonedDateTime updatedDate;



    @Column
    private String name;

    @Column
    private String position;

    @Column
    private String email;

    @ManyToOne
    @JoinColumn(name = "social_contact_id")
    private SocialContact socialContact;


    @OneToMany
    @JoinTable(name = "outlet_addresses",
            joinColumns = @JoinColumn(name = "social_contact_id"),
            inverseJoinColumns = @JoinColumn(name = "outlet_id")
    )
    private Set<Address> addresses;

    @OneToMany
    @JoinTable(name = "outlet_phones",
            joinColumns = @JoinColumn(name = "outlet_id"),
            inverseJoinColumns = @JoinColumn(name = "phone_id")
    )
    private Set<Phone> phones;
}
