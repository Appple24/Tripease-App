package com.sudhanva.demo.service;
import com.sudhanva.demo.dto.request.CabRequest;
import com.sudhanva.demo.dto.response.CabResponse;
import com.sudhanva.demo.exception.DriverNotFoundException;
import com.sudhanva.demo.model.Cab;
import com.sudhanva.demo.model.Driver;
import com.sudhanva.demo.repository.CabRepository;
import com.sudhanva.demo.repository.DriverRepository;
import com.sudhanva.demo.transformers.CabTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CabService {

    @Autowired
    private DriverRepository driverRepository;
    public CabResponse registerCab(CabRequest cabRequest,int driverId) {

        Optional<Driver> optionalDriver=driverRepository.findById(driverId);
        if(optionalDriver.isEmpty()){
            throw new DriverNotFoundException("Invalid Driver Id :"+driverId);
        }
        Driver driver=optionalDriver.get();
        Cab cab = CabTransformer.cabRequestToCab(cabRequest);
        driver.setCab(cab);
        Driver savedDriver=driverRepository.save(driver);
        return CabTransformer.cabToCabResponse(savedDriver.getCab(),savedDriver);
    }
}
