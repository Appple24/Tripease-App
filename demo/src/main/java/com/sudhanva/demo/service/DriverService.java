package com.sudhanva.demo.service;

import com.sudhanva.demo.dto.request.DriverRequest;
import com.sudhanva.demo.dto.response.DriverResponse;
import com.sudhanva.demo.model.Driver;
import com.sudhanva.demo.repository.DriverRepository;
import com.sudhanva.demo.transformers.DriverTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    public DriverResponse addDriver(DriverRequest driverRequest){
        Driver driver= DriverTransformer.DriverRequestToDriver(driverRequest);
        driverRepository.save(driver);
        return DriverTransformer.DriverToDriverResponse(driver);
    }
}
