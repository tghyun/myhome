package com.godcoder.myhome.model;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="ev_event")
@SequenceGenerator(
     name="EVENT_SEQ_GEN",
     sequenceName="EV_EVENT_SEQ",
     initialValue = 1,
     allocationSize = 1
)
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "EVENT_SEQ_GEN")
    private Integer event_id;
    private Integer user_id;
    private String event_type;
    private String event_title;
    private String event_desc;
    private String event_score;

}
