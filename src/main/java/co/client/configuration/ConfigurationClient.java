package co.client.configuration;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/v1/games")
@RegisterRestClient
@ApplicationScoped
public interface ConfigurationClient {

  @GET
  List<Game> getAllGames();
}
