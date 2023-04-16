package com.a.assignment.service;

import com.a.assignment.dto.FileDto;
import com.a.assignment.model.File;
import com.a.assignment.model.Item;
import com.a.assignment.model.Permissions;
import com.a.assignment.repo.FileRepo;
import com.a.assignment.repo.ItemRepo;
import com.a.assignment.repo.PermissionsRepo;
import com.a.assignment.utils.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    private final Path root = Paths.get("uploads");

    @Autowired
    FileRepo fileRepo;
    @Autowired
    PermissionsRepo permissionsRepo;

    @Autowired
    ItemRepo itemRepo;





    public Item createFile (FileDto fileDto)
    {
        Item resaultItem;
        Permissions permission = permissionsRepo.findByUserEmail(fileDto.getUserEmail());
        if(permission.getGroup().getGroup_name().equals("admins")){
            Item parentItem = itemRepo.findByName(fileDto.getParentName()).orElseThrow(() -> new RuntimeException("Space not found"));
            Item item = new Item();
            item.setName(fileDto.getName());
            item.setType(Type.valueOf(fileDto.getType()));
            item.setPermissionGroup(permission.getGroup());
            item.setParentItem(parentItem);
            resaultItem = itemRepo.save(item);
        }else {
            throw new RuntimeException("not authorized to edit in this space");
        }
        save(fileDto.getFile(),resaultItem);
        return resaultItem;
    }

    public void save(MultipartFile file, Item fileItem) {
        try {
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            File FileDB = new File(1L, file.getBytes(), file.getContentType(), fileItem );
            fileRepo.save(FileDB);
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("file already exists.");
            }

            throw new RuntimeException(e.getMessage());
        }
    }

}
