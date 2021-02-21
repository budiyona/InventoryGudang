package com.budiyono.invgudang.controller;

import com.budiyono.invgudang.model.Courier;
import com.budiyono.invgudang.model.ItemCategory;
import com.budiyono.invgudang.service.ServiceCourier;
import com.budiyono.invgudang.util.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class CourierController {

    @Autowired
    ServiceCourier serviceCourier;

    @GetMapping("/couriersnolimit")
    public ResponseEntity<List<Courier>> listAllitemCourier() {
        String limit="0", offset="0";
        return new ResponseEntity<>(serviceCourier.findAllCourier(limit,offset), HttpStatus.OK);
    }

    @GetMapping("/couriers")
    public ResponseEntity<List<Courier>> listAllitemCourier(@RequestParam String limit, String offset) {

        return new ResponseEntity<>(serviceCourier.findAllCourier(limit,offset), HttpStatus.OK);
    }

    @GetMapping("/courier/{id}")
    public ResponseEntity<?> getItemCourier(@PathVariable("id") String id) {
        Courier target = serviceCourier.findById(id);
        if (target == null) {
            return new ResponseEntity<>(new CustomErrorType("Data is not found"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(target, HttpStatus.OK);
        }
    }

    @GetMapping("/courier/uname/{uname}")
    public ResponseEntity<?> getItemCourierName(@PathVariable("name") String uname) {
        Courier target = serviceCourier.findByUName(uname);
        if (target == null) {
            return new ResponseEntity<>(new CustomErrorType("Data is not found"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(target, HttpStatus.OK);
        }
    }

    @PostMapping("/courier/")
    public ResponseEntity<?> createCourier(@RequestBody Courier courier) {
        Courier target = serviceCourier.findByUName(courier.getUsernameCourier());
        if (target == null) {
            serviceCourier.saveCourier(courier);
            return new ResponseEntity<>(courier, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new CustomErrorType("Data with Username = " +
                    target.getUsernameCourier() + " Already exist"), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/courier/{id}")
    public ResponseEntity<?> updateCourier(@PathVariable("id") String id, @RequestBody Courier courier) {
        Courier targetId = serviceCourier.findById(id);
        if (targetId == null) {
            return new ResponseEntity<>(new CustomErrorType("Data is not found"), HttpStatus.NOT_FOUND);
        } else {
            Courier targetName = serviceCourier.findByUName(courier.getUsernameCourier());
            if (targetName == null) {
                serviceCourier.updateCourier(courier);
                return new ResponseEntity<>(courier, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new CustomErrorType("Data with Username = " +
                        courier.getUsernameCourier() + " Already exist"), HttpStatus.CONFLICT);
            }
        }
    }

    @DeleteMapping("/courier/{id}")
    public ResponseEntity<?> delCourier(@PathVariable("id") String id) {
        Courier target = serviceCourier.findById(id);
        if (target == null) {
            return new ResponseEntity<>(new CustomErrorType("Data is not found"), HttpStatus.NOT_FOUND);
        } else {
            serviceCourier.deleteCourier(id);
            return new ResponseEntity<>(target, HttpStatus.OK);
        }
    }
}
