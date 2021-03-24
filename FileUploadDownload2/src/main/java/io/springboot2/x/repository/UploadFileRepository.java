package io.springboot2.x.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.springboot2.x.domain.UploadFile;

@Repository
public interface UploadFileRepository extends JpaRepository<UploadFile, Integer> {
	@Query("select upload.fileId,upload.fileName from  UploadFile  upload")
	public List<Object[]>   getFilesIdsAndNames() ;
	
}  
