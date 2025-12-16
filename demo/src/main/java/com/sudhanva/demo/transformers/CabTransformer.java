package com.sudhanva.demo.transformers;

import com.sudhanva.demo.dto.request.CabRequest;
import com.sudhanva.demo.dto.response.CabResponse;
import com.sudhanva.demo.dto.response.DriverResponse;
import com.sudhanva.demo.model.Cab;
import com.sudhanva.demo.model.Driver;

public class CabTransformer {
    public static CabResponse cabToCabResponse(Cab cab, Driver driver) {

        return CabResponse.builder().
                CabNumber(cab.getCabNumber()).
                CabModel(cab.getCabModel()).
                perKmRate(cab.getPerKmRate()).
                available(cab.isAvailable()).
                driver(DriverTransformer.DriverToDriverResponse(driver)).
                build();
    }

    public static Cab cabRequestToCab(CabRequest cabRequest) {

        return Cab.builder().
                CabNumber(cabRequest.getCabNumber()).
                CabModel(cabRequest.getCabModel()).
                perKmRate(cabRequest.getPerKmRate()).
                build();
    }
}
