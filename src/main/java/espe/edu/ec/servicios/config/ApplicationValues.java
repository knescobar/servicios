package espe.edu.ec.servicios.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ApplicationValues {
  private final String mongoHost;
  private final String mongoDB;
  private final String mongoUsr;
  private final String mongoPwd;
  private final String mongoAut;

  public ApplicationValues(
      @Value("${examen.server.mongo.host}") String mongoHost,
      @Value("${examen.server.mongo.db}") String mongoDB,
      @Value("${examen.server.mongo.usr}") String mongoUsr,
      @Value("${examen.server.mongo.pwd}") String mongoPwd,
      @Value("${examen.server.mongo.aut}") String mongoAut) {

    this.mongoHost = mongoHost;
    this.mongoDB = mongoDB;
    this.mongoUsr = mongoUsr;
    this.mongoPwd = mongoPwd;
    this.mongoAut = mongoAut;
  }
}
