package espe.edu.ec.servicios.service;

import espe.edu.ec.servicios.dao.EstudianteRepository;
import espe.edu.ec.servicios.exception.ExisteException;
import espe.edu.ec.servicios.model.Estudiante;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    private EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }


    public void crearEstudiante (Estudiante estudiante){

        Optional <Estudiante> estdb = this.estudianteRepository.findByCedula(estudiante.getCedula());

        if(estdb.isPresent()){
            throw new ExisteException(
                    "No se puede crear estudiante, cedula:"+estudiante.getCedula()+" ya existe");
        }
        this.estudianteRepository.save(estudiante);
    }
    public List<Estudiante> obtenerEstudiantesNivel(Integer nivel){
        return  this.estudianteRepository.findByNivel(nivel);
    }


}
