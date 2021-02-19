package com.budiyono.invgudang.controller;

import com.budiyono.invgudang.model.Curier;
import com.budiyono.invgudang.model.Item;
import com.budiyono.invgudang.model.ItemCategory;
import com.budiyono.invgudang.model.Transaction;
import com.budiyono.invgudang.service.ServiceCategory;
import com.budiyono.invgudang.service.ServiceCurier;
import com.budiyono.invgudang.service.ServiceItem;
import com.budiyono.invgudang.service.ServiceTransaction;
import com.budiyono.invgudang.util.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TransactionController {
    @Autowired
    ServiceTransaction serviceTransaction;

    @Autowired
    ServiceCurier serviceCurier;

    @Autowired
    ServiceItem serviceItem;

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
            Curier targetCurier = serviceCurier.findById(transaction.getCourier().getIdCurier());
            if (targetCurier != null) {
                int i = 0;
                for (Item item : transaction.getItems()) {
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
                    return new ResponseEntity<>(new CustomErrorType("Data Curier with id = " +
                            transaction.getItems().get(i).getIdItem() + " Not Found"), HttpStatus.NOT_FOUND);
                }

            } else {
                return new ResponseEntity<>(new CustomErrorType("Data Curier with id = " +
                        transaction.getCourier().getIdCurier() + " Not Found"), HttpStatus.NOT_FOUND);
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
            if (targetName == null) {
                Curier targetCurier = serviceCurier.findById(transaction.getCourier().getIdCurier());
                if (targetCurier != null) {
                    int i = 0;
                    for (Item item : transaction.getItems()) {
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
                        return new ResponseEntity<>(new CustomErrorType("Data Curier with id = " +
                                transaction.getItems().get(i).getIdItem() + " Not Found"), HttpStatus.NOT_FOUND);
                    }
                } else {

                    return new ResponseEntity<>(new CustomErrorType("Data Curier with id = " +
                            transaction.getCourier().getIdCurier() + " Not Found"), HttpStatus.NOT_FOUND);
                }
            } else {
                return new ResponseEntity<>(new CustomErrorType("Data with name = " +
                        targetName.getNameItemTrx() + " Already exist"), HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>(new CustomErrorType("Data Transaction with id = " +
                    transaction.getIdItemTrx() + " Not Found"), HttpStatus.NOT_FOUND);
        }

    }
}
