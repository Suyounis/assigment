package com.a.assignment.controller;

import com.a.assignment.dto.FileDto;
import com.a.assignment.dto.FolderDto;
import com.a.assignment.dto.SpaceDto;
import com.a.assignment.model.Item;
import com.a.assignment.service.FileService;
import com.a.assignment.service.FolderService;
import com.a.assignment.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ItemController {


    @Autowired
    SpaceService spaceService;

    @Autowired
    FolderService folderService;

    @Autowired
    FileService fileService;

    @PostMapping("/space")
    public Item addSpace(@RequestBody SpaceDto spaceDto){
       Item item = spaceService.createSpace(spaceDto);
       return item;
    }

    @PostMapping("/folder")
    public Item addFolder(@RequestBody FolderDto folderDto){
        Item item =folderService.createFolder(folderDto);
        return item;
    }

    @PostMapping("/file")
    public Item addFile(@RequestParam("file") MultipartFile file, @RequestParam("name") String name,@RequestParam("type") String type
            , @RequestParam("userEmail") String userEmail, @RequestParam("parentName") String parentName){

        FileDto fileDto = new FileDto();
        fileDto.setFile(file);
        fileDto.setName(name);
        fileDto.setParentName(parentName);
        fileDto.setUserEmail(userEmail);
        fileDto.setType(type);
        Item item = fileService.createFile(fileDto);
        return item;
    }

}
