package com.a.assignment.service;

import com.a.assignment.dto.FolderDto;
import com.a.assignment.model.Item;
import com.a.assignment.model.Permissions;
import com.a.assignment.repo.ItemRepo;
import com.a.assignment.repo.PermissionsGroupRepo;
import com.a.assignment.repo.PermissionsRepo;
import com.a.assignment.utils.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FolderService {

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    PermissionsGroupRepo groupRepo ;

    @Autowired
    PermissionsRepo permissionsRepo ;

    public Item createFolder(FolderDto folderDto){
        Permissions permission = permissionsRepo.findByUserEmail(folderDto.getUserEmail());
        if(permission.getGroup().getGroup_name().equals("admins")){
           Item parentItem = itemRepo.findById(folderDto.getParentId()).orElseThrow(() -> new RuntimeException("Space not found"));
            Item item = new Item();
           item.setName(folderDto.getName());
           item.setType(Type.valueOf(folderDto.getType()));
           item.setPermissionGroup(permission.getGroup());
           item.setParentItem(parentItem);
           Item resItem = itemRepo.save(item);
           return resItem;
        }else {
            throw new RuntimeException("not authorized to edit in this space");
        }
    }


}
