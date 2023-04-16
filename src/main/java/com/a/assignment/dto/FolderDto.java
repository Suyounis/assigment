package com.a.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FolderDto {

    private String type;
    private String name;
    private String userEmail;
    private Long parentId;

}
