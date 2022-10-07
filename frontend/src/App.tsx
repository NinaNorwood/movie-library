import React from 'react';
import './App.css';
import useMovies from "./hooks/useMovies";
import MovieLibrary from "./components/MovieLibrary";
import NewMovie from "./components/NewMovie";

function App() {

    const {movies, addMovies, deleteMovie} = useMovies();

  return (
    <div className="App">
      <header className="App-header">
          <h1>Movie-Library</h1>
          <MovieLibrary movies={movies} deleteMovie={deleteMovie}/>
          <NewMovie newMovie={addMovies}/>
      </header>
    </div>
  );
}

export default App;
