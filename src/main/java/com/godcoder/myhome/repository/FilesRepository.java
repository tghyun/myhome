package com.godcoder.myhome.repository;

import com.godcoder.myhome.model.Files;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilesRepository extends JpaRepository<Files, Integer> {
}
