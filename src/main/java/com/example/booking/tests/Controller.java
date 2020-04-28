package com.example.booking.tests;

import com.example.booking.requests.AppointmentRequest;
import com.example.booking.requests.SearchRequest;
import com.example.booking.responses.AppointmentResponse;
import com.example.booking.responses.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    Servicee servicee;


    @RequestMapping(value = "/searchh",method = RequestMethod.GET)
    public List<SearchResponse> doThings(@RequestBody SearchRequest request) throws Exception {

        return servicee.Run(request);
    }
    @RequestMapping(value = "/populate")
    public void populateDb() throws Exception {
        servicee.populate();
    }

    @RequestMapping(value = "/makeAppointmentt", method = RequestMethod.POST)
    public AppointmentResponse makeAppointment(@RequestBody AppointmentRequest request) throws ParseException {

       return servicee.makeAppointment(request);
    }
}
