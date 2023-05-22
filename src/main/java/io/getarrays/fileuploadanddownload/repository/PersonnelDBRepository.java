package io.getarrays.fileuploadanddownload.repository;

import io.getarrays.fileuploadanddownload.model.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelDBRepository extends JpaRepository<Personnel, String> {

}