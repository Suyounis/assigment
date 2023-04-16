package com.a.assignment.dto;

import com.a.assignment.utils.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpaceDto {

    private String type;
    private String name;
    private Long permissionGroupId;
}
