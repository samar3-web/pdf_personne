package io.getarrays.fileuploadanddownload.service;

import io.getarrays.fileuploadanddownload.model.Personnel;
import io.getarrays.fileuploadanddownload.repository.PersonnelDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@Service
public class PersonnelService {

    @Autowired
    private PersonnelDBRepository filePersonnelDBRepository;

    public Personnel store(String matricule,MultipartFile file, String prenom, String pnom, LocalDate datenaiss,LocalDate daterecrute, String decisionRecrutement,String cin,String cnrps,String rib,String etat) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Personnel Personnel = new Personnel(matricule,fileName, file.getContentType(), file.getBytes(),prenom,pnom,datenaiss,daterecrute,decisionRecrutement,cin,cnrps,rib,etat);

        return filePersonnelDBRepository.save(Personnel);
    }

    public Personnel getFile(String id) {
        return filePersonnelDBRepository.findById(id).get();
    }

    public Stream<Personnel> getAllFiles() {
        return filePersonnelDBRepository.findAll().stream();
    }
    public List<Personnel> getAllUsers() {
        return filePersonnelDBRepository.findAll();

    }
}
