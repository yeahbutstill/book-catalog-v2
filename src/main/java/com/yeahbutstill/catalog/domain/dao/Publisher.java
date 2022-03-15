package com.yeahbutstill.catalog.domain.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "publisher")
public class Publisher extends AbstractBaseEntity {
    /**
     *
     */
    private static final long serialVersionUID = -3729325249054365078L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publisher_generator")
    @SequenceGenerator(name = "publisher_generator", sequenceName = "publisher_id_seq", allocationSize = 1, initialValue = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;

}
