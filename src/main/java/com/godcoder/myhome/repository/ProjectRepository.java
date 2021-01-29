package com.godcoder.myhome.repository;

import com.godcoder.myhome.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,String> {
}
