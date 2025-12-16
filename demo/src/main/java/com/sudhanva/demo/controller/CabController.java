package com.sudhanva.demo.controller;

import com.sudhanva.demo.dto.request.CabRequest;
import com.sudhanva.demo.dto.response.CabResponse;
import com.sudhanva.demo.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cab")
public class CabController {
    @Autowired
    private CabService cabService;

    @PostMapping("/register/driver/{driverid}")
    public CabResponse registerCab(@RequestBody CabRequest cabRequest,
                              @PathVariable("driverid") int driverId)
    {
        return cabService.registerCab(cabRequest,driverId);
    }
}
