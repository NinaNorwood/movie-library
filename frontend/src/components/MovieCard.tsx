import {Movie} from "./Movie";
import "./MovieCard.css"


type MovieCardProps = {
    movie : Movie;
    deleteMovie : (id : string) => void
}

export default function MovieCard(props : MovieCardProps) {
    return(
        <div className="movie-card">
            <img src={props.movie.posterURL} alt={props.movie.title}/>
            <h5>{props.movie.title} ({props.movie.year})</h5>
            <button onClick={() => props.deleteMovie(props.movie.id)}>Delete this book</button>
        </div>

    )


}