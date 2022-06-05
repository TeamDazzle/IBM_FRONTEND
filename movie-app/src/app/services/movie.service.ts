import { Injectable } from '@angular/core';
import { Movie } from '../model/movie.model';
import { Show } from '../model/show.model';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  movies : Movie[] = [];

  shows : Show[] = [];

  constructor() { }

  save_movie(movie : Movie){
    this.movies.push(movie);
  }

  list_movie() : Movie[]{
    return this.movies;
  }

  remove_movie(idx : number){
    return this.movies.splice(idx, 1);
  }

  save_show(show : Show){
    this.shows.push(show);
  }

  list_show() : Show[]{
    return this.shows;
  }

  remove_show(idx : number){
    return this.shows.splice(idx, 1);
  }
}
