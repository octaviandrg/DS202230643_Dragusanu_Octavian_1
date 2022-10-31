package ro.tuc.ds2022.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2022.dtos.ConsumptionDto;
import ro.tuc.ds2022.dtos.builders.ConsumptionBuilder;
import ro.tuc.ds2022.entities.Consumption;
import ro.tuc.ds2022.repositories.ConsumptionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsumptionService {

    @Autowired
    private ConsumptionRepository consumptionRepository;

    public List<ConsumptionDto> getAllConsumptions(){
        return consumptionRepository.findAll().stream().map(ConsumptionBuilder::toConsumptionDto).collect(Collectors.toList());
    }

    public Long createConsumption(ConsumptionDto consumptionDto){
        return consumptionRepository.save(ConsumptionBuilder.toEntity(consumptionDto)).getId();
    }

    public List<ConsumptionDto> getConsumptionsByDeviceId(Long deviceId){
        return consumptionRepository.findAllByDeviceId(deviceId).stream().map(ConsumptionBuilder::toConsumptionDto).collect(Collectors.toList());
    }


}
