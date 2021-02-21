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
@CrossOrigin(origins = "http://localhost:3000")
public class ItemCategoryController {

    @Autowired
    ServiceCategory serviceCategory;

    @GetMapping("/itemcategoriesnolimit")
    public ResponseEntity<List<ItemCategory>> listAllitemCategory() {
        String limit="0",offset="0";
        return new ResponseEntity<>(serviceCategory.findAllItemCategory(limit,offset), HttpStatus.OK);
    }

    @GetMapping("/itemcategories")
    public ResponseEntity<List<ItemCategory>> listAllitemCategory(@RequestParam String limit, String offset) {
        return new ResponseEntity<>(serviceCategory.findAllItemCategory(limit,offset), HttpStatus.OK);
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

    @DeleteMapping("/itemcategory/{id}")
    public ResponseEntity<?> delItemCategoryById(@PathVariable("id") String id) {
        ItemCategory target = serviceCategory.findById(id);
        if (target == null) {
            return new ResponseEntity<>(new CustomErrorType("Data is not found"), HttpStatus.NOT_FOUND);
        } else {
            serviceCategory.deleteItemById(id);
            return new ResponseEntity<>(target, HttpStatus.OK);
        }
    }

    @DeleteMapping("/itemcategory/name/{name}")
    public ResponseEntity<?> delItemCategoryByName(@PathVariable("name") String name) {
        ItemCategory target = serviceCategory.findByName(name);
        if (target == null) {
            return new ResponseEntity<>(new CustomErrorType("Data is not found"), HttpStatus.NOT_FOUND);
        } else {
            serviceCategory.deleteItemByName(name);
            return new ResponseEntity<>(target, HttpStatus.OK);
        }
    }

    @PostMapping("/itemcategories/")
    public ResponseEntity<?> createItemCategories(@RequestBody List<ItemCategory> itemCategories) {
        boolean statuList = false;
        ItemCategory target = new ItemCategory();
        for (ItemCategory itemCategory : itemCategories) {
            target = serviceCategory.findByName(itemCategory.getNameCategory());
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
                    target.getNameCategory() + " Already exist"), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/itemcategory/")
    public ResponseEntity<?> createItemCategory(@RequestBody ItemCategory itemCategory) {
        ItemCategory target = serviceCategory.findByName(itemCategory.getNameCategory());
        if (target == null) {
            serviceCategory.saveItemCategory(itemCategory);
            return new ResponseEntity<>(itemCategory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new CustomErrorType("Data with name = " +
                    target.getNameCategory() + " Already exist"), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/itemcategory/{id}")
    public ResponseEntity<?> updateItemCategory(@PathVariable("id") String id, @RequestBody ItemCategory itemCategory) {
        ItemCategory targetId = serviceCategory.findById(id);
        if (targetId == null) {
            return new ResponseEntity<>(new CustomErrorType("Data is not found"), HttpStatus.NOT_FOUND);
        } else {
            ItemCategory targetName = serviceCategory.findByName(itemCategory.getNameCategory());
            if (targetName == null) {
                serviceCategory.updateItemCategory(itemCategory);
                return new ResponseEntity<>(itemCategory, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new CustomErrorType("Data with name = " +
                        itemCategory.getNameCategory() + " Already exist"), HttpStatus.CONFLICT);
            }
        }
    }
}
