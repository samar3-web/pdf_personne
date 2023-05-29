package com.archive.ArchiveGN.controller;

import com.archive.ArchiveGN.message.ResponseMessage;
import com.archive.ArchiveGN.model.DemandeMutation;
import com.archive.ArchiveGN.model.Personnel;
import com.archive.ArchiveGN.service.DemandeMutationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/demande-mutations")
@CrossOrigin("http://localhost:4200")

public class DemandeMutationController {
    private final DemandeMutationService demandeMutationService;

    @Autowired
    public DemandeMutationController(DemandeMutationService demandeMutationService) {
        this.demandeMutationService = demandeMutationService;
    }


    @PostMapping
    public ResponseEntity<ResponseMessage> createDemandeMutation(@RequestParam("file") MultipartFile file,
                                                                 @RequestParam("dateinsert") LocalDate dateinsert,
                                                                 @RequestParam("datedemande") Date datedemande,
                                                                 @RequestParam("decision")String decision,
                                                                 @RequestParam("cause") String cause,
                                                                 @RequestParam("personnel") Personnel personnel
                                                                 ) {
        String message = "";
        try {
            demandeMutationService.saveDemandeMutation(file,dateinsert,datedemande,decision,cause,personnel);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping
    public ResponseEntity<List<DemandeMutation>> getAllDemandeMutations() {
        List<DemandeMutation> demandeMutations = demandeMutationService.getAllDemandeMutations();
        return ResponseEntity.ok(demandeMutations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DemandeMutation> getDemandeMutationById(@PathVariable int id) {
        Optional<DemandeMutation> demandeMutation = demandeMutationService.getDemandeMutationById(id);
        return demandeMutation.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDemandeMutation(@PathVariable int id) {
        demandeMutationService.deleteDemandeMutation(id);
        return ResponseEntity.noContent().build();
    }
}