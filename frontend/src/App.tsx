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
          <div>
              {movies.length=== 0
                  && <h3>No movies available</h3>}
          </div>
          <MovieLibrary movies={movies} deleteMovie={deleteMovie}/>
          <NewMovie newMovie={addMovies}/>
      </header>
    </div>
  );
}

export default App;
