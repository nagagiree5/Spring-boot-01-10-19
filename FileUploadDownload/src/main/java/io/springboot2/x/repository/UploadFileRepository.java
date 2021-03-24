package io.springboot2.x.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.springboot2.x.entity.UploadFile;
@Repository
public interface UploadFileRepository extends JpaRepository<UploadFile, Integer> {
	@Query("select uf.fileId, uf.fileName from UploadFile uf")
    public List<Object[]> getFieldsAndNames();
	
		
	}
