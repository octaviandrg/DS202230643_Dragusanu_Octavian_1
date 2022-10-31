package ro.tuc.ds2022.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2022.dtos.ConsumptionDto;
import ro.tuc.ds2022.service.ConsumptionService;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping(value = "/consumption")
public class ConsumptionController {

    @Autowired
    private ConsumptionService consumptionService;

    @GetMapping("/all")
    public ResponseEntity<?> getConsumptions(){
        return new ResponseEntity<>(consumptionService.getAllConsumptions(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createConsumption(@Valid @RequestBody ConsumptionDto consumptionDto){
        Long idClient = consumptionService.createConsumption(consumptionDto);
        return new ResponseEntity<>("Consumption created with id " + idClient, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getConsumptionByDeviceId(@PathVariable(name = "id") Long deviceId) throws Exception {
        return new ResponseEntity<>(consumptionService.getConsumptionsByDeviceId(deviceId), HttpStatus.OK);
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<?> updateConsumption(@PathVariable(name = "id") Long clientId,
//                                          @Valid @RequestBody ClientDto clientDto){
//        ClientDto updatedClient = consumptionService.updateClient(clientId, clientDto);
//        return new ResponseEntity<>(updatedClient, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deleteConsumption(@PathVariable(name = "id") Long clientId){
//        consumptionService.deleteClient(clientId);
//        return new ResponseEntity<>("Client deleted!", HttpStatus.OK);
//    }





}
