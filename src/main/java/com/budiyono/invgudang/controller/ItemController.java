package com.budiyono.invgudang.controller;

import com.budiyono.invgudang.model.Item;
import com.budiyono.invgudang.model.ItemCategory;
import com.budiyono.invgudang.service.ServiceCategory;
import com.budiyono.invgudang.service.ServiceItem;
import com.budiyono.invgudang.util.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ItemController {
    @Autowired
    ServiceItem serviceItem;

    @Autowired
    ServiceCategory serviceCategory;

    @GetMapping("/itemsnolimit")
    public ResponseEntity<List<Item>> listAllitemCategory() {
        String limit="0", offset="0";
        return new ResponseEntity<>(serviceItem.findAllItem(limit,offset), HttpStatus.OK);
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> listAllitemCategory(@RequestParam String limit, String offset) {
        return new ResponseEntity<>(serviceItem.findAllItem(limit,offset), HttpStatus.OK);
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<?> getItemById(@PathVariable("id") String id) {
        Item target = serviceItem.findById(id);
        if (target == null) {
            return new ResponseEntity<>(new CustomErrorType("Data is not found"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(target, HttpStatus.OK);
        }
    }

    @GetMapping("/item/name/{name}")
    public ResponseEntity<?> getItemName(@PathVariable("name") String name) {
        Item target = serviceItem.findByName(name);
        if (target == null) {
            return new ResponseEntity<>(new CustomErrorType("Data is not found"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(target, HttpStatus.OK);
        }
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<?> delItemById(@PathVariable("id") String id) {
        Item target = serviceItem.findById(id);
        if (target == null) {
            return new ResponseEntity<>(new CustomErrorType("Data is not found"), HttpStatus.NOT_FOUND);
        } else {
            serviceItem.deleteItem(id);
            return new ResponseEntity<>(target, HttpStatus.OK);
        }
    }

    @PostMapping("/item/")
    public ResponseEntity<?> createItem(@RequestBody Item item) {
        Item target = serviceItem.findByName(item.getNameItem());
        if (target == null) {
            ItemCategory targetCat = serviceCategory.findById(item.getItemCategory().getIdCategory());
            if (targetCat == null) {
                return new ResponseEntity<>(new CustomErrorType("Data category with id = " +
                        item.getItemCategory().getIdCategory() + " Not Found"), HttpStatus.NOT_FOUND);
            } else {
                serviceItem.saveItem(item);
                return new ResponseEntity<>(item, HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>(new CustomErrorType("Data with name = " +
                    target.getNameItem() + " Already exist"), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/item/{id}")
    public ResponseEntity<?> updateItem(@PathVariable("id") String id, @RequestBody Item item) {
        Item targetId = serviceItem.findById(id);
        if (targetId == null) {
            return new ResponseEntity<>(new CustomErrorType("Data is not found"), HttpStatus.NOT_FOUND);
        } else {
            Item targetName = serviceItem.findByName(item.getNameItem());
            if (targetName == null) {
                serviceItem.updateItem(item);
                return new ResponseEntity<>(item, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new CustomErrorType("Data with name = " +
                        item.getNameItem() + " Already exist"), HttpStatus.CONFLICT);
            }
        }
    }

    @PutMapping("/item/dec")
    public ResponseEntity<?> decItem(@RequestParam String id, Integer qty){
        Item target = serviceItem.findById(id);
        if(target.getStock()>qty){
            int stokSkrng = target.getStock()-qty;
            target.setStock(stokSkrng);
            serviceItem.updateItem(target);
            return new ResponseEntity<>(target, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new CustomErrorType("Max Qty = " +
                    target.getStock()), HttpStatus.BAD_REQUEST);

        }
    }
    @PutMapping("/item/inc")
    public ResponseEntity<?> incItem(@RequestParam String id, Integer qty){
        Item target = serviceItem.findById(id);
            int stokSkrng = target.getStock()+qty;
            target.setStock(stokSkrng);
            serviceItem.updateItem(target);
            return new ResponseEntity<>(target, HttpStatus.OK);
    }
}
