package com.a.assignment.service;

import com.a.assignment.dto.SpaceDto;
import com.a.assignment.model.Item;
import com.a.assignment.model.PermissionGroup;
import com.a.assignment.repo.ItemRepo;
import com.a.assignment.repo.PermissionsGroupRepo;
import com.a.assignment.utils.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpaceService {
    @Autowired
    ItemRepo itemRepo;
    @Autowired
    PermissionsGroupRepo groupRepo ;

    public Item createSpace(SpaceDto spaceDto)
    {
        PermissionGroup group = groupRepo.findById(spaceDto.getPermissionGroupId()).orElseThrow(() -> new RuntimeException("no such permission group"));
        Item space = new Item();
        space.setName(spaceDto.getName());
        space.setType(Type.valueOf(spaceDto.getType()));
        space.setPermissionGroup(group);
        return itemRepo.save(space);
    }
}
