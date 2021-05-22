package UploadFile.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import UploadFile.model.Music;

@Repository
public interface MusicRepo extends JpaRepository<Music, String> {

}