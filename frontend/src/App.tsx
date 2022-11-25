import React from 'react';
import './App.css';
import useMovies from "./hooks/useMovies";
import MovieLibrary from "./components/MovieLibrary";
import NewMovie from "./components/NewMovie";
import {toast, ToastContainer} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';

function App() {

    const {movies, addMovies, deleteMovie} = useMovies();

    const testToast = () => {
        toast.success("Hello!");
    }


  return (
    <div className="App">
        <ToastContainer/>
      <header className="App-header">
          <h1>Movie-Library</h1>
          <MovieLibrary movies={movies} deleteMovie={deleteMovie}/>
          <NewMovie newMovie={addMovies}/>
          <button onClick={testToast}>Press me</button>
      </header>
    </div>
  );
}

export default App;
