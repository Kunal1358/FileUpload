package UploadFile.service;


import java.io.IOException;
import java.util.stream.Stream;

import UploadFile.model.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import UploadFile.repo.MusicRepo;

@Service
public class MusicService {


    @Autowired
    private MusicRepo MusicRepo;

    public Music store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Music FileDB = new Music(fileName, file.getContentType(), file.getBytes());

        return MusicRepo.save(FileDB);
    }

    public Music getFile(String id) {
        return MusicRepo.findById(id).get();
    }

    public Stream<Music> getAllFiles() {
        return MusicRepo.findAll().stream();
    }

}
