package com.archive.ArchiveGN.repository;

import com.archive.ArchiveGN.model.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelDBRepository extends JpaRepository<Personnel, Integer> {

}