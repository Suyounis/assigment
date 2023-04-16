package com.a.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileDto {

  private MultipartFile file ;
  private String userEmail;
  private String parentName;
  private String name;
  private String type;

}
