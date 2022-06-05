import { Component, OnInit } from '@angular/core';
import { Movie } from '../model/movie.model';
import { MovieService } from '../services/movie.service';

@Component({
  selector: 'app-list-movies',
  templateUrl: './list-movies.component.html',
  styleUrls: ['./list-movies.component.css']
})
export class ListMoviesComponent implements OnInit {

  movies : Movie[] = [];

  constructor(private service : MovieService) { }

  ngOnInit(): void {
    this.movies = this.service.list_movie();
  }

  delete(i : number){
    var ans = confirm("Are you sure to delete?");
    if(ans)
      this.service.remove_movie(i);
  }
}
