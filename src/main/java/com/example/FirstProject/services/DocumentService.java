package com.example.FirstProject.services;

import com.example.FirstProject.entities.Document;
import com.example.FirstProject.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public void saveDocument() throws IOException {
        File file = new File("C:\\Users\\user\\Downloads\\Word.docx");
        Document document = new Document();
        byte[] bytes =  Files.readAllBytes(file.toPath());
        document.setName(file.getName());
        document.setSize(bytes.length);
        document.setContent(bytes);
        documentRepository.save(document);
    }
    public Document uploadDocument(MultipartFile multipartFiles) throws IOException {
        String filename = StringUtils.cleanPath(Objects.requireNonNull(multipartFiles.getOriginalFilename()));
        if (!Objects.equals(multipartFiles.getContentType(), "application/pdf")) {
            throw new IllegalArgumentException("Invalid file type. Only PDF files are allowed.");
        }
        Document document = new Document();
        document.setName(filename);
        document.setDateCreation(new Date());
        document.setContent(multipartFiles.getBytes());
        document.setSize(multipartFiles.getSize());
        document.setUploadTime(new Date());

        return documentRepository.save(document);
    }
    public ResponseEntity<byte[]> downloadDocument(Long id) throws Exception{
        Optional<Document> result = documentRepository.findById(id);
        if(result.isEmpty()) {
            throw new Exception("Could not find Document with ID: " + id);
        }
        Document document =result.get();
        System.out.println("the document is downloaded successfully!");
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getName() + "\"")
                .body(document.getContent());
    }

}