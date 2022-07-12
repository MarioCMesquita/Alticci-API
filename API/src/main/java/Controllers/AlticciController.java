package Controllers;

import Services.AlticciService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/alticci")
public class AlticciController {

    @Inject
    AlticciService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String GetAlticci(@QueryParam("number") int number)
    {
        try
        {
           return "Result: " + service.GetAlticci(number);
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }
}