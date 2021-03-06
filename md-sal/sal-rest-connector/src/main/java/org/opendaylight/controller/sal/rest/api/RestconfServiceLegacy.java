package org.opendaylight.controller.sal.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.opendaylight.controller.sal.restconf.impl.StructuredData;
import org.opendaylight.yangtools.yang.data.api.CompositeNode;

public interface RestconfServiceLegacy {

    public static final String XML = "+xml";
    public static final String JSON = "+json";
    
    @Deprecated
    @GET
    @Path("/datastore")
    @Produces({Draft01.MediaTypes.DATASTORE+JSON,Draft01.MediaTypes.DATASTORE+XML})
    public StructuredData readAllData();

    @Deprecated
    @GET
    @Path("/datastore/{identifier:.+}")
    @Produces({Draft01.MediaTypes.DATA+JSON,Draft01.MediaTypes.DATA+XML, 
               MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
    public StructuredData readData(@PathParam("identifier") String identifier);

    @Deprecated
    @POST
    @Path("/datastore/{identifier:.+}")
    @Produces({Draft01.MediaTypes.DATA+JSON,Draft01.MediaTypes.DATA+XML, 
               MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
    public Response createConfigurationDataLegacy(@PathParam("identifier") String identifier, CompositeNode payload);

    @Deprecated
    @PUT
    @Path("/datastore/{identifier:.+}")
    @Produces({Draft01.MediaTypes.DATA+JSON,Draft01.MediaTypes.DATA+XML, 
               MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
    public Response updateConfigurationDataLegacy(@PathParam("identifier") String identifier, CompositeNode payload);

}
