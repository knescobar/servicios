package espe.edu.ec.servicios.dao;

import espe.edu.ec.servicios.model.Aula;
import espe.edu.ec.servicios.model.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface AulaRepository extends MongoRepository<espe.edu.ec.servicios.model.Aula, String> {

    List<Estudiante> findByNivelAndParalelo(Integer nivel, String paralelo);

    Optional <Aula>  findByParaleloAndNivel(String paralelo, Integer nivel);
}
