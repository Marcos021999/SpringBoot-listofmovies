package ferreia.marcos.listofmovies.control;

import ferreia.marcos.listofmovies.model.Attributes;
import ferreia.marcos.listofmovies.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesControl {

    //mostrar o BD
    @Autowired

    private MoviesRepository moviesRepository;
    @GetMapping
    public ResponseEntity<List<Attributes>> findAll(){
        return new ResponseEntity<List<Attributes>>(
                (List<Attributes>) this.moviesRepository.findAll(),
                new HttpHeaders(), HttpStatus.OK);//error 404

    }

    //buscar
    @GetMapping(path = "/{id}")
    public ResponseEntity<Attributes> findById(@PathVariable("id") long id) {
        if(this.moviesRepository.findById(id).isPresent()){
            return new ResponseEntity<Attributes>(
                    this.moviesRepository.findById(id).get(),
                    new HttpHeaders(),
                    HttpStatus.OK);

        }
        return new ResponseEntity<Attributes>(HttpStatus.NOT_FOUND);
    }

    //adicionar

    @PostMapping
    public ResponseEntity<Attributes> register (@RequestBody Attributes attributes) {
        return new ResponseEntity<Attributes> (
                this.moviesRepository.save(attributes),
                new HttpHeaders(),
                HttpStatus.CREATED
        );

    }

    // criando um método para atualizar.
    @PutMapping(value = "/{id}")
    public ResponseEntity<Attributes> atualizar (@PathVariable("id") long id, @RequestBody Attributes attributes) throws Exception {

        if(id == 0 || !this.moviesRepository.existsById(id)){
            throw  new Exception("Código não encontrado ou inexistente!");

        }
        return new ResponseEntity<Attributes>(
                this.moviesRepository.save(attributes),
                new HttpHeaders(),
                HttpStatus.OK);

    }

    //deletar
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Attributes> delete (@PathVariable("id") long id ){
        this.moviesRepository.deleteById(id);
        return new ResponseEntity<Attributes>(new HttpHeaders(), HttpStatus.OK);
    }
}
