import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from '../model/movie.model';
import { MovieService } from '../services/movie.service';

@Component({
  selector: 'app-add-movie',
  templateUrl: './add-movie.component.html',
  styleUrls: ['./add-movie.component.css']
})
export class AddMovieComponent implements OnInit {

  movie : Movie = new Movie();

  constructor(private service : MovieService, private router : Router) { }

  ngOnInit(): void {
  }

  add(){
    this.service.save_movie(this.movie);
    this.router.navigate(['list_movies']);
  }
}
