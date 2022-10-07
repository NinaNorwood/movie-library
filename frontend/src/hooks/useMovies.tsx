import {useEffect, useState} from "react";
import axios from "axios";

export default function useMovies() {

    const [movies, setMovies] = useState([]);

    useEffect(() => {
        getMovies()
    }, [])

    const getMovies = () => {
        axios.get("/api/movie/")
            .then((response) => {return response.data
            })
            .then((movies) => {setMovies(movies)
            })
            .catch(error => {console.error(error)})
    }

    const addMovies = (title:string, posterURL:string, year:string) => {
        let newMovie = {
            title: title,
            posterURL: posterURL,
            year: year,
        }
        axios.post("/api/movie/", newMovie)
            .then((response) => {return response.data
            })
            .then(getMovies)
    }

    const deleteMovie = (id: string) => {

        axios.delete("/api/movie/" + id)
            .then(getMovies)
    }


    return (
        {movies, addMovies, deleteMovie}
    )
}