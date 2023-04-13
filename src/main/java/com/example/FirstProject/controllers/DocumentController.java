package com.example.FirstProject.controllers;

import com.example.FirstProject.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/documents")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadDocument(@RequestParam("document") MultipartFile multipartFiles) throws Exception {
        documentService.uploadDocument(multipartFiles);
        return ResponseEntity.ok().body("saved succefuly");
    }
    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadDocument(@RequestParam("id") Long id) throws Exception{
        return null;

    }
}