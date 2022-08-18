package espe.edu.ec.servicios.resource;

import espe.edu.ec.servicios.model.Aula;
import espe.edu.ec.servicios.model.Estudiante;
import espe.edu.ec.servicios.service.AulaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aula")
@RequiredArgsConstructor
public class AulaResoruce {

    private  final AulaService aulaService;

    @GetMapping("/{nivel}/{paralelo}")
    public ResponseEntity<List<Estudiante>> findAccountByNumber(@PathVariable Integer nivel,  @PathVariable String paralelo) {
        return ResponseEntity.ok(this.aulaService.listadoCodigoYNivel(nivel, paralelo));
    }

    @PutMapping(path = "/{cedula}/{nivel}")
    public ResponseEntity<Aula> asiganarAula(@PathVariable String cedula, @PathVariable Integer nivel) {
         this.aulaService.asignarAular(cedula, nivel);
        return ResponseEntity.ok().build();
    }


}
