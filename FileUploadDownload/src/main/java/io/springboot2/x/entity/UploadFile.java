package io.springboot2.x.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="FILES")
public class UploadFile {
	
	@GenericGenerator(name = "g1", strategy = "increment")
	
	@Id
	@GeneratedValue(generator = "g1")
	@Column(name = "F_ID")
	private Integer fileId;
	
	@Column(name="F_NAME",length = 25)
	private String fileName;
	
	@Column(name = "F_DATA")
	@Lob
	private byte[] fileData;

	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
}
