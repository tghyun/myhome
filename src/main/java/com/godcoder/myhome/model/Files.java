package com.godcoder.myhome.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name="ev_file")
@SequenceGenerator(
        name = "FILE_SEQ_GEN",
        sequenceName = "EV_FILE_SEQ",
        initialValue = 1,
        allocationSize = 1
)
@Data
public class Files {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "FILE_SEQ_GEN")
    private Integer file_id;
    private String orig_file_name;
    private String file_name;
    private String file_path;
    private Integer event_id;
}
