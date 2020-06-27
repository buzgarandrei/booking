package com.example.booking.tests;

import com.example.booking.requests.AppointmentRequest;
import com.example.booking.requests.SearchRequest;
import com.example.booking.responses.AppointmentResponse;
import com.example.booking.responses.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    Servicee servicee;


    @Autowired
    public RequestMappingHandlerMapping requestMappingHandlerMapping;

    @RequestMapping("/endpoints")
    public @ResponseBody
    Object showEndpointsAction() throws SQLException
    {
        return requestMappingHandlerMapping.getHandlerMethods().keySet().stream().map(t ->
                (t.getMethodsCondition().getMethods().size() == 0 ? "GET" : t.getMethodsCondition().getMethods().toArray()[0]) + " " +
                        t.getPatternsCondition().getPatterns().toArray()[0]
        ).toArray();
    }

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
