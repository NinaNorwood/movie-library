import {Movie} from "./Movie";
import MovieCard from "./MovieCard";


type MovieLibraryProps = {
    movies : Movie[];
    deleteMovie : (id : string) => void
}

export default function MovieLibrary(props : MovieLibraryProps) {
    return (
        <div>
            {props.movies.map((movie) =>
                <div>
                    <MovieCard movie={movie} deleteMovie={props.deleteMovie}/>
                </div>)}
        </div>
    )
}