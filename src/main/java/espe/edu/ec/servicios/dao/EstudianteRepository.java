package espe.edu.ec.servicios.dao;

import espe.edu.ec.servicios.model.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface EstudianteRepository  extends MongoRepository<Estudiante, String> {

    Optional<Estudiante> findByCedula(String cedula);

    List<Estudiante> findByNivel(Integer nivel);
    Optional<Estudiante> findByCedulaAndNivel(String cedula, Integer nivel);


}
