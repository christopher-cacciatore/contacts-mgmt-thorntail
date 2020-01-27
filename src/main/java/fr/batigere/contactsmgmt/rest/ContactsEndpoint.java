package fr.batigere.contactsmgmt.rest;

import fr.batigere.contactsmgmt.rest.dtos.Contact;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
@Path("/contacts")
public class ContactsEndpoint {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contact> getAllContacts(){
        Contact c1 = new Contact();
        c1.setId("1");
        c1.setAddress("2 rue des moulins");
        c1.setCity("Metzervisse");
        c1.setEmail("jacques.paul@mail.fr");
        c1.setSalutation("M.");
        c1.setFirstName("Jacques");
        c1.setLastName("Paul");
        c1.setPhoneHome("+33387225478");
        c1.setPhoneMobile("+33645698741");
        c1.setZipCode("57940");
        c1.setUserName("jacques.paul");


        Contact c2 = new Contact();
        c2.setId("2");
        c2.setAddress("2 rue des moulins");
        c2.setCity("Metzervisse");
        c2.setEmail("micheline.paul@mail.fr");
        c2.setSalutation("Mme.");
        c2.setFirstName("Micheline");
        c2.setLastName("Paul");
        c2.setPhoneHome("+33387225478");
        c2.setPhoneMobile("+33612345678");
        c2.setZipCode("57940");
        c2.setUserName("micheline.paul01");

        return Arrays.asList(c1, c2);
    }

    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Contact getContactById(@PathParam("username") String userName){
        Contact c2 = new Contact();
        c2.setId("1");
        c2.setAddress("2 rue des moulins");
        c2.setCity("Metzervisse");
        c2.setEmail(userName+"@mail.fr");
        c2.setSalutation("Dr.");
        if(userName.contains(".")) {
            c2.setFirstName(userName.split("\\.")[0]);
            c2.setLastName(userName.split("\\.")[1]);
        } else {
            c2.setFirstName(userName);
            c2.setLastName("unknown");
        }
        c2.setPhoneHome("+33387225478");
        c2.setPhoneMobile("+33612345678");
        c2.setZipCode("57940");
        c2.setUserName(userName);

        return c2;
    }

}
