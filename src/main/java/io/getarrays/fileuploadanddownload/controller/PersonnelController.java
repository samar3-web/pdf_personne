package io.getarrays.fileuploadanddownload.controller;

import io.getarrays.fileuploadanddownload.message.ResponseFile;
import io.getarrays.fileuploadanddownload.message.ResponseMessage;
import io.getarrays.fileuploadanddownload.model.Personnel;
import io.getarrays.fileuploadanddownload.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@CrossOrigin("http://localhost:8081")
public class PersonnelController {

    @Autowired
    private PersonnelService storageService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file,
                                                      @RequestParam("prenom") String prenom,
                                                      @RequestParam("pnom") String pnom,
                                                      @RequestParam("datenaiss") LocalDate datenaiss,
                                                      @RequestParam("daterecrute") LocalDate daterecrute,
                                                      @RequestParam("decisionRecrutement") String decisionRecrutement,
                                                      @RequestParam("cin") String cin,
                                                      @RequestParam("cnrps") String cnrps,
                                                      @RequestParam("rib") String rib,
                                                      @RequestParam("etat") String etat) {
        String message = "";
        try {
            // Save the file with the prenom
            storageService.store(file, prenom,pnom,datenaiss,daterecrute,decisionRecrutement,cin,cnrps,rib,etat);

            message = "Uploaded the file successfully: " + file.getOriginalFilename() + ". First Name: " + prenom;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }



    @GetMapping("/files")
    public ResponseEntity<List<ResponseFile>> getListFiles() {
        List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(dbFile.getId())
                    .toUriString();

            return new ResponseFile(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length,
                    dbFile.getId(),
                    dbFile.getPrenom(),
                    dbFile.getPnom(),
                    dbFile.getDatenaiss(),
                    dbFile.getDaterecrute(),
                    dbFile.getDecisionRecrutement(),
                    dbFile.getCin(),
                    dbFile.getCnrps(),
                    dbFile.getRib(),
                    dbFile.getEtat());
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        Personnel personnel = storageService.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + personnel.getName() + "\"")
                .body(personnel.getData());
    }

}
