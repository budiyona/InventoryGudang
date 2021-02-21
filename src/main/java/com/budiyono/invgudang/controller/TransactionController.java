package com.budiyono.invgudang.controller;

import com.budiyono.invgudang.model.*;
import com.budiyono.invgudang.service.ServiceCourier;
import com.budiyono.invgudang.service.ServiceItem;
import com.budiyono.invgudang.service.ServiceTransaction;
import com.budiyono.invgudang.util.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class TransactionController {
    @Autowired
    ServiceTransaction serviceTransaction;

    @Autowired
    ServiceCourier serviceCourier;

    @Autowired
    ServiceItem serviceItem;
    @GetMapping("/transaction/prefix/{pref}")
    public ResponseEntity<?> getPrefix (@PathVariable("pref") String pref){

        return new ResponseEntity<>(Collections.singletonMap("prefix", serviceTransaction.getPrefix(pref)),HttpStatus.OK);
    }
    @GetMapping("/transactions")
    public ResponseEntity<List<Transaction>> listAllTransaction(@RequestParam String limit, String offset) {
        return new ResponseEntity<>(serviceTransaction.findAllTransaction(limit, offset), HttpStatus.OK);
    }

    @GetMapping("/transaction/{id}")
    public ResponseEntity<?> getTransactionById(@PathVariable("id") String id) {
        Transaction target = serviceTransaction.findById(id);
        if (target == null) {
            return new ResponseEntity<>(new CustomErrorType("Data is not found"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(target, HttpStatus.OK);
        }
    }

    @GetMapping("/transaction/name/{name}")
    public ResponseEntity<?> getTransactionName(@PathVariable("name") String name) {
        Transaction target = serviceTransaction.findByName(name);
        if (target == null) {
            return new ResponseEntity<>(new CustomErrorType("Data is not found"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(target, HttpStatus.OK);
        }
    }

    @DeleteMapping("/transaction/{id}")
    public ResponseEntity<?> delTransactionById(@PathVariable("id") String id) {
        Transaction target = serviceTransaction.findById(id);
        if (target == null) {
            return new ResponseEntity<>(new CustomErrorType("Data is not found"), HttpStatus.NOT_FOUND);
        } else {
            serviceTransaction.deleteTransaction(id);
            return new ResponseEntity<>(target, HttpStatus.OK);
        }
    }

    @PostMapping("/transaction/")
    public ResponseEntity<?> createTransaction(@RequestBody Transaction transaction) {
        boolean statusList = false;
        Transaction target = serviceTransaction.findByName(transaction.getNameItemTrx());
        if (target == null) {
            Courier targetCourier = serviceCourier.findById(transaction.getCourier().getIdCourier());
            if (targetCourier != null) {
                int i = 0;
                for (ItemInOut item : transaction.getItems()) {
                    Item targetItem = serviceItem.findById(item.getIdItem());
                    if (targetItem == null) {
                        statusList = false;
                        break;
                    } else {
                        statusList = true;
                    }
                    i++;
                }

                if (statusList) {
                    serviceTransaction.saveTransaction(transaction);
                    return new ResponseEntity<>(transaction, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(new CustomErrorType("Data Courier with id = " +
                            transaction.getItems().get(i).getIdItem() + " Not Found"), HttpStatus.NOT_FOUND);
                }

            } else {
                return new ResponseEntity<>(new CustomErrorType("Data Courier with id = " +
                        transaction.getCourier().getIdCourier() + " Not Found"), HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(new CustomErrorType("Data with name = " +
                    target.getNameItemTrx() + " Already exist"), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/transaction/{id}")
    public ResponseEntity<?> updateTransaction(@PathVariable("id") String id, @RequestBody Transaction transaction) {
        boolean statusList = false;
        Transaction targetId = serviceTransaction.findById(transaction.getIdItemTrx());
        if (targetId != null) {
            Transaction targetName = serviceTransaction.findByName(transaction.getNameItemTrx());
            if (targetName != null) {
                Courier targetCourier = serviceCourier.findById(transaction.getCourier().getIdCourier());
                if (targetCourier != null) {
                    int i = 0;
                    for (ItemInOut item : transaction.getItems()) {
                        Item targetItem = serviceItem.findById(item.getIdItem());
                        if (targetItem == null) {
                            statusList = false;
                            break;
                        } else {
                            statusList = true;
                        }
                        i++;
                    }

                    if (statusList) {
                        serviceTransaction.updateTransaction(transaction);
                        return new ResponseEntity<>(transaction, HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>(new CustomErrorType("Data Courier with id = " +
                                transaction.getItems().get(i).getIdItem() + " Not Found"), HttpStatus.NOT_FOUND);
                    }
                } else {

                    return new ResponseEntity<>(new CustomErrorType("Data Courier with id = " +
                            transaction.getCourier().getIdCourier() + " Not Found"), HttpStatus.NOT_FOUND);
                }
            } else {
                return new ResponseEntity<>(new CustomErrorType("Data with name = " +
                        targetName.getNameItemTrx() + " NOT FOUND"), HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(new CustomErrorType("Data Transaction with id = " +
                    transaction.getIdItemTrx() + " Not Found"), HttpStatus.NOT_FOUND);
        }

    }
}
