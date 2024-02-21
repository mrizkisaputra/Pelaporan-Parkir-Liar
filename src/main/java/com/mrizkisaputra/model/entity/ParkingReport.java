package com.mrizkisaputra.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Data @Entity(name = "report_parking")
@NoArgsConstructor
public class ParkingReport {
    @Id
    @GeneratedValue(generator = "system-uuid") @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @Column(name = "photo_url",  unique = true, nullable = false)
    private String photoUrl;

    @Column(name = "plat_number", unique = true, nullable = false)
    private String platNumber;

    private String longitude;

    private String latitude;

    private String description;

    @ManyToMany
    @JoinTable(
            name = "users_report_parking",
            joinColumns = {@JoinColumn(name = "id_report_parking", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "id_user", referencedColumnName = "id")}
    )
    private Set<User> users;
}
