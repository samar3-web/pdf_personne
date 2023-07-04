package com.archive.ArchiveGN.service;

import com.archive.ArchiveGN.model.DemandeMutation;
import com.archive.ArchiveGN.model.Personnel;
import com.archive.ArchiveGN.repository.DemandeMutationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DemandeMutationService {
    private final DemandeMutationRepository demandeMutationRepository;

    @Autowired
    public DemandeMutationService(DemandeMutationRepository demandeMutationRepository) {
        this.demandeMutationRepository = demandeMutationRepository;
    }


    public DemandeMutation saveDemandeMutation(MultipartFile file, String cause, String decision ,String datedemande, Personnel personnel,String Dname, String Dtype) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        DemandeMutation DemandeMutation = new DemandeMutation(cause,decision,fileName,file.getContentType(), file.getBytes(),datedemande,personnel,Dname,Dtype);

        return demandeMutationRepository.save(DemandeMutation);
    }

    public List<DemandeMutation> getAllDemandeMutations() {
        return demandeMutationRepository.findAll();
    }

    public Optional<DemandeMutation> getDemandeMutationById(int id) {
        return demandeMutationRepository.findById(id);
    }



    public void deleteDemandeMutation(int id) {
        demandeMutationRepository.deleteById(id);
    }
}