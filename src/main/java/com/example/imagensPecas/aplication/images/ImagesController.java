package com.example.imagensPecas.aplication.images;

import com.example.imagensPecas.domain.entity.Image;
import com.example.imagensPecas.domain.enums.ImageExtension;
import com.example.imagensPecas.domain.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/v1/images")
@Slf4j
public class ImagesController {

    private ImageService service;

    @PostMapping
    public ResponseEntity save(
            @RequestParam("file")MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("tags") List<String> tags
    )
    {
        log.info("Imagem recebida: name: {}, size: {}", file.getOriginalFilename(), file.getSize());

        Image image = Image.builder()
                .name(name)
                .tags(String.join(",", tags))
                .size(file.getSize())
                .extension(ImageExtension.valueOf(MediaType.valueOf(file.getContentType())))
                .file(file.getBytes())
                .build();
        service.save(image);

        //log.info("Nome definido para a imagem: {}", name);
        //log.info("Tags: {}", tags);
        log.info("Content type: {}", file.getContentType());
        return ResponseEntity.ok().build();
    }
}