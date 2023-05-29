package com.archive.ArchiveGN.controller;

import com.archive.ArchiveGN.message.ResponseFile;
import com.archive.ArchiveGN.message.ResponseMessage;
import com.archive.ArchiveGN.model.Personnel;
import com.archive.ArchiveGN.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin("http://localhost:4200")
public class PersonnelController {

    @Autowired
    private PersonnelService storageService;




}
