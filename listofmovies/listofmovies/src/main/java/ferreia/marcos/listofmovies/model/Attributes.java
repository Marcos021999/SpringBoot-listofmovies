package ferreia.marcos.listofmovies.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "movies")
public class Attributes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movies")
    private long id;

    @Column(name = "namemovie")
    private String namemovie;

    @Column(name = "genre")
    private String genre;

    @Column(name = "director")
    private String director;
}
