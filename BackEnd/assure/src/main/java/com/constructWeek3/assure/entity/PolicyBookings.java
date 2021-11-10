package com.constructWeek3.assure.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PolicyBookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private Date bookingDate;
    private String policyName;
    private Float coverAmount;
    private Float premium;
    private Integer coverTenure;

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Set<Members> members = new HashSet<Members>();

    @JsonIgnore

    @ManyToOne
    private Policy policy;

    @ManyToOne
    private User user;

    public void addMember(Members member) {
        members.add(member);
    }


}
