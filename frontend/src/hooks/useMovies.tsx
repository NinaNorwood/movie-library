import {useEffect, useState} from "react";
import axios from "axios";
import {toast} from "react-toastify";

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
            .catch(error => toast.error(error.message))
            //.catch({console.error(error)})
    }

    const addMovies = (title:string, posterURL:string, year:string) => {
        let newMovie = {
            title: title,
            posterURL: posterURL,
            year: year,
        }
        axios.post("/api/movie/", newMovie)
            .then (() => toast.success("Movie added successfully!"))
          //  .then((response) => {return response.data})
            .catch(error => toast.error(error.message))
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