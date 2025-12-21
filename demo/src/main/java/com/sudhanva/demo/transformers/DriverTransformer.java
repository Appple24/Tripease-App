package com.sudhanva.demo.transformers;

import com.sudhanva.demo.dto.request.DriverRequest;
import com.sudhanva.demo.dto.response.DriverResponse;
import com.sudhanva.demo.model.Driver;

public class DriverTransformer {
    public static DriverResponse DriverToDriverResponse(Driver driver){
        return DriverResponse.builder().driverID(driver.getDriverID())
                .driverName(driver.getDriverName())
                .age(driver.getAge())
                .email(driver.getEmail())
                .build();
    }

    public static Driver DriverRequestToDriver(DriverRequest driverRequest){
        return Driver.builder().
                driverName(driverRequest.getDriverName()).
                email(driverRequest.getEmail()).
                age(driverRequest.getAge()).
                build();
    }
}
