package ro.tuc.ds2022.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ro.tuc.ds2022.entities.Device;

import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
public class ConsumptionDto {

    private Long id;

    private Long deviceId;

    private Date timestamp;

    private Double value;

    public ConsumptionDto(Long deviceId, Date timestamp, Double value) {
        this.deviceId = deviceId;
        this.timestamp = timestamp;
        this.value = value;
    }

    public ConsumptionDto(Long id, Long deviceId, Date timestamp, Double value) {
        this.id = id;
        this.deviceId = deviceId;
        this.timestamp = timestamp;
        this.value = value;
    }


    public ConsumptionDto() {
    }
}
