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


@RequestMapping("/personnel")
@RestController
@CrossOrigin("http://localhost:4200")
public class PersonnelController {

    @Autowired
    private PersonnelService storageService;


    @RequestMapping(method = RequestMethod.GET)
    public List<Personnel> getAllPersonnel(){
        return storageService.getAllPersonnel();
    }


    @RequestMapping(value = "/{matricule}",method = RequestMethod.GET)
    public Personnel getPersonnelById(@PathVariable(value = "matricule") int matricule){
        return storageService.getPersonnelById(matricule);
    }


    @RequestMapping(method = RequestMethod.POST)
    public Personnel createPersonnel(@RequestBody Personnel personnel){
        return storageService.savePersonnel(personnel);
    }


    @RequestMapping(value="/{matricule}" ,method = RequestMethod.PUT)
    public Personnel updatePersonnel(@RequestBody Personnel personnel,@PathVariable(value = "matricule") int matricule){
        personnel.setMatricule(matricule);
        return storageService.updatePersonnel(personnel);
    }

    @RequestMapping(value="/{idPersonnel}",method = RequestMethod.DELETE)
    public void deletePersonnelById(@PathVariable(value = "idPersonnel") int id){
        storageService.deletePersonnelById(id);
    }



}