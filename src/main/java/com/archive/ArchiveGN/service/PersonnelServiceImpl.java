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

@Service
public class PersonnelServiceImpl implements PersonnelService {
    @Autowired
    PersonnelDBRepository persRepo;


    @Override
    public Personnel savePersonnel(Personnel personnel) {
        return persRepo.save(personnel);
    }

    @Override
    public Personnel updatePersonnel(Personnel personnel) {
        return persRepo.save(personnel);
    }

    @Override
    public void deletePersonnel(Personnel personnel) {
        persRepo.delete(personnel);
    }

    @Override
    public void deletePersonnelById(int matricule) {
        persRepo.deleteById(matricule);
    }

    @Override
    public Personnel getPersonnelById(int matricule) {
        return persRepo.findById(matricule).orElse(null);
    }

    @Override
    public List<Personnel> getAllPersonnel() {
        return persRepo.findAll();
    }
}