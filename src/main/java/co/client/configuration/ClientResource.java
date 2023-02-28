package co.client.configuration;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("v1/games")
public class ClientResource {

  @Inject
  @RestClient
  ConfigurationClient configurationClient;

  @GET
  public Response getAllGames() {
    try{
      List<Game> allGames = configurationClient.getAllGames();
      System.out.println(allGames);
      return Response.ok(allGames).build();
    }catch (Exception ex){
      ex.printStackTrace();
      throw ex;
    }

  }
}
