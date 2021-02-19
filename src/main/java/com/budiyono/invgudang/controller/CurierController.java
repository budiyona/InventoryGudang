package com.budiyono.invgudang.controller;

import com.budiyono.invgudang.model.Curier;
import com.budiyono.invgudang.model.ItemCategory;
import com.budiyono.invgudang.service.ServiceCategory;
import com.budiyono.invgudang.service.ServiceCurier;
import com.budiyono.invgudang.util.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CurierController {

    @Autowired
    ServiceCurier serviceCurier;

    @GetMapping("/curiers")
    public ResponseEntity<List<Curier>> listAllitemCurier(@RequestParam String limit, String offset) {

        return new ResponseEntity<>(serviceCurier.findAllCurier(limit,offset), HttpStatus.OK);
    }

    @GetMapping("/curier/{id}")
    public ResponseEntity<?> getItemCurier(@PathVariable("id") String id) {
        Curier target = serviceCurier.findById(id);
        if (target == null) {
            return new ResponseEntity<>(new CustomErrorType("Data is not found"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(target, HttpStatus.OK);
        }
    }

    @GetMapping("/curier/name/{name}")
    public ResponseEntity<?> getItemCategoryName(@PathVariable("name") String name) {
        Curier target = serviceCurier.findByName(name);
        if (target == null) {
            return new ResponseEntity<>(new CustomErrorType("Data is not found"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(target, HttpStatus.OK);
        }
    }

    @PostMapping("curier/")
    public ResponseEntity<?> createItemCategory(@RequestBody Curier curier) {
        Curier target = serviceCurier.findByName(curier.getUsernameCurier());
        if (target == null) {
            serviceCurier.saveCurier(curier);
            return new ResponseEntity<>(curier, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new CustomErrorType("Data with Username = " +
                    target.getUsernameCurier() + " Already exist"), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("curier/{id}")
    public ResponseEntity<?> updateItemCategory(@PathVariable("id") String id, @RequestBody Curier curier) {
        Curier targetId = serviceCurier.findById(id);
        if (targetId == null) {
            return new ResponseEntity<>(new CustomErrorType("Data is not found"), HttpStatus.NOT_FOUND);
        } else {
            Curier targetName = serviceCurier.findByName(curier.getUsernameCurier());
            if (targetName == null) {
                serviceCurier.updateCurier(curier);
                return new ResponseEntity<>(curier, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new CustomErrorType("Data with Username = " +
                        curier.getUsernameCurier() + " Already exist"), HttpStatus.CONFLICT);
            }
        }
    }
}
