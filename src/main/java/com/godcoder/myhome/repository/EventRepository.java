package com.godcoder.myhome.repository;

import com.godcoder.myhome.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EventRepository extends JpaRepository<Event,Integer> {

    @Query(value="select " +
            " max(a.g_event_type) as g_event_type " +
            " from (" +
            " select " +
            " user_id," +
            " replace(wm_concat(event_type)over(partition by user_id order by event_type),',') as g_event_type " +
            " from ev_event where user_id = :user_id) a " +
            " group by a.user_id"
            ,nativeQuery = true)
    String findByUserId(@Param("user_id") Integer user_id);

    @Query(value="select event_id from ev_event where user_id = :user_id and event_type = :event_type " ,nativeQuery = true)
    int findEventId(@Param("user_id") Integer user_id, @Param("event_type") String event_type);


}
