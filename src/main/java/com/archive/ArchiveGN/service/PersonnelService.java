package com.archive.ArchiveGN.service;

import com.archive.ArchiveGN.repository.PersonnelDBRepository;
import com.archive.ArchiveGN.model.Personnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public interface PersonnelService {
    Personnel savePersonnel(Personnel personnel);
    Personnel updatePersonnel(Personnel personnel);
    void deletePersonnel(Personnel personnel);
    void deletePersonnelById(int matricule);
    Personnel getPersonnelById(int matricule);
    List<Personnel> getAllPersonnel();
}

