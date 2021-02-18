package com.budiyono.invgudang.controller;

import com.budiyono.invgudang.model.ItemCategory;
import com.budiyono.invgudang.service.ServiceCategory;
import com.budiyono.invgudang.util.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemCategoryController {

    @Autowired
    ServiceCategory serviceCategory;

    @GetMapping("/itemcategories/{initRow}")
    public ResponseEntity<List<ItemCategory>> listAllitemCategory(@PathVariable("initRow") String initRow) {

        return new ResponseEntity<>(serviceCategory.findAllItemCategory(initRow), HttpStatus.OK);
    }

    @GetMapping("/itemcategory/{id}")
    public ResponseEntity<?> getItemCategoryById(@PathVariable("id") String id) {
        ItemCategory target = serviceCategory.findById(id);
        if (target == null) {
            return new ResponseEntity<>(new CustomErrorType("Data is not found"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(target, HttpStatus.OK);
        }
    }

    @GetMapping("/itemcategory/name/{name}")
    public ResponseEntity<?> getItemCategoryName(@PathVariable("name") String name) {
        ItemCategory target = serviceCategory.findByName(name);
        if (target == null) {
            return new ResponseEntity<>(new CustomErrorType("Data is not found"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(target, HttpStatus.OK);
        }
    }

    @DeleteMapping("itemcategory/{id}")
    public ResponseEntity<?> delItemCategoryById(@PathVariable("id") String id) {
        ItemCategory target = serviceCategory.findById(id);
        if (target == null) {
            return new ResponseEntity<>(new CustomErrorType("Data is not found"), HttpStatus.NOT_FOUND);
        } else {
            serviceCategory.deleteItemById(id);
            return new ResponseEntity<>(target, HttpStatus.OK);
        }
    }

    @DeleteMapping("itemcategory/name/{name}")
    public ResponseEntity<?> delItemCategoryByName(@PathVariable("name") String name) {
        ItemCategory target = serviceCategory.findByName(name);
        if (target == null) {
            return new ResponseEntity<>(new CustomErrorType("Data is not found"), HttpStatus.NOT_FOUND);
        } else {
            serviceCategory.deleteItemByName(name);
            return new ResponseEntity<>(target, HttpStatus.OK);
        }
    }

    @PostMapping("itemcategories/")
    public ResponseEntity<?> createItemCategory(@RequestBody List<ItemCategory> itemCategories) {
        boolean statuList = false;
        ItemCategory target = new ItemCategory();
        for (ItemCategory itemCategory : itemCategories) {
            target = serviceCategory.findByName(itemCategory.getNameCateory());
            if (target == null) {
                statuList = true;
            } else {
                statuList = false;
                break;
            }
        }
        if (statuList) {
            serviceCategory.saveItemCategories(itemCategories);
            return new ResponseEntity<>(itemCategories, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new CustomErrorType("Data with name = " +
                    target.getNameCateory() + " Already exist"), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("itemcategory/{id}")
    public ResponseEntity<?> updateItemCategory(@PathVariable("id") String id,@RequestBody ItemCategory itemCategory) {
        ItemCategory targetId = serviceCategory.findById(id);
        if (targetId == null) {
            return new ResponseEntity<>(new CustomErrorType("Data is not found"), HttpStatus.NOT_FOUND);
        } else {
            ItemCategory targetName = serviceCategory.findByName(itemCategory.getNameCateory());
            if (targetName == null) {
                serviceCategory.updateItemCategory(itemCategory);
                return new ResponseEntity<>(itemCategory, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new CustomErrorType("Data with name = " +
                        itemCategory.getNameCateory() + " Already exist"), HttpStatus.CONFLICT);
            }
        }
    }
}
