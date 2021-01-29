package com.godcoder.myhome.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name="TCC_PROJ_CODE")
public class Project {
    @Id
    private String proj_code;
    private String proj_name;
    private Date close_dt;
}
