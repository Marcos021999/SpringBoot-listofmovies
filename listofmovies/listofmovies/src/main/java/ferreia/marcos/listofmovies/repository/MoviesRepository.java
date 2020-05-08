package ferreia.marcos.listofmovies.repository;

import ferreia.marcos.listofmovies.model.Attributes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends CrudRepository<Attributes, Long> {
}
