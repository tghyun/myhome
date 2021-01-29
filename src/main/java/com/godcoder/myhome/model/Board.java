package com.godcoder.myhome.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="tcc_employe")
public class Board {
    @Id
    private String user_no;
    private String user_nm;
    private String empno;

}
