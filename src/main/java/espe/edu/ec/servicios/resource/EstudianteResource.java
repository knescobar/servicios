package espe.edu.ec.servicios.resource;

import espe.edu.ec.servicios.model.Estudiante;
import espe.edu.ec.servicios.service.EstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/estudiante")
@RequiredArgsConstructor
public class EstudianteResource {
    private final EstudianteService estudianteService;

    @GetMapping("/{nivel}")
    public ResponseEntity<List<Estudiante>> findAccountByNumber(@PathVariable Integer nivel) {
        return ResponseEntity.ok(this.estudianteService.obtenerEstudiantesNivel(nivel));
    }

    @PostMapping
    public ResponseEntity<Estudiante> crear(@RequestBody Estudiante estudiante) {
        this.estudianteService.crearEstudiante(estudiante);
        return ResponseEntity.ok().build();
    }
}
