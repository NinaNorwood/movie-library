import {Movie} from "./Movie";
import MovieCard from "./MovieCard";
import "./MovieLibrary.css"
import {useState} from "react";
import NewMovie from "./NewMovie";


type MovieLibraryProps = {
    movies : Movie[];
    deleteMovie : (id : string) => void
}

export default function MovieLibrary(props : MovieLibraryProps) {

    const [filterText, setFilterText] = useState("");

    const result = props.movies.filter((movie) => movie.title.toLowerCase().includes(filterText.toLowerCase()));

    return (
        <div >
            <div >
                <label>Search here for movies
             <input onChange={(event) =>
                setFilterText(event.target.value)}/>
                </label>
            </div>
            <div className="movie-library">
                 {result.map((movie) =>
                    <MovieCard movie={movie} deleteMovie={props.deleteMovie}/>)}
            </div>
        </div>
    )
}