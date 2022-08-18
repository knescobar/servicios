package espe.edu.ec.servicios.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@CompoundIndexes({
        @CompoundIndex(name = "index_aula", def = "{'paralelo' : 1, 'nivel' : 1}")
})
@Document(collection = "aulas")
@TypeAlias("aulas")
public class Aula {

    @Id
    private  String id;

    private  String paralelo;

    private Integer nivel;

    private List<Estudiante> estudiantes;
}
