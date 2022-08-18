package espe.edu.ec.servicios.service;

import espe.edu.ec.servicios.dao.AulaRepository;
import espe.edu.ec.servicios.dao.EstudianteRepository;
import espe.edu.ec.servicios.exception.EntityNotFoundException;
import espe.edu.ec.servicios.model.Aula;
import espe.edu.ec.servicios.model.Estudiante;
import org.springframework.stereotype.Service;
import java.util.Random;

import java.util.List;
import java.util.Optional;

@Service
public class AulaService {

    private  AulaRepository aulaRepository;
    private EstudianteRepository estudianteRepository;
    public AulaService(AulaRepository aulaRepository, EstudianteRepository estudianteRepository) {
        this.aulaRepository = aulaRepository;
        this.estudianteRepository = estudianteRepository;
    }

    public List<Estudiante>  listadoCodigoYNivel(Integer nivel, String codigo){
        return  this.aulaRepository.findByNivelAndParalelo(nivel, codigo);
    }

    public void asignarAular(String cedula, Integer nivel){


        Estudiante estudiante =  obtenerPorcedulaNivel(cedula, nivel);
        Random random = new Random();
        char paralelo = (char) (random.nextInt(3) + 'a');

        Aula aulaOpt = obtenerAula(String.valueOf(paralelo), nivel);

        aulaOpt.getEstudiantes().add(estudiante);
        aulaOpt.setNivel(nivel);
        aulaOpt.setParalelo(String.valueOf(paralelo));
        this.aulaRepository.save(aulaOpt);

    }

    public Estudiante obtenerPorcedulaNivel (String cedula, Integer nivel){
        Optional<Estudiante> groupOpt = this.estudianteRepository.findByCedulaAndNivel(cedula, nivel);
        return groupOpt.orElseThrow(
                () -> new EntityNotFoundException("Estudiante no existe"));
    }

    public Aula obtenerAula(String paralelo, Integer nivel){
        Optional<Aula> aulaOpt =
                this.aulaRepository.findByParaleloAndNivel(paralelo,nivel);
        return aulaOpt.orElseThrow(
                () -> new EntityNotFoundException("Aula no existe"));

    }

}
