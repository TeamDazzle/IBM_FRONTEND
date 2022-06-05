import { Component, OnInit } from '@angular/core';
import { Movie } from '../model/movie.model';
import { MovieService } from '../services/movie.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

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
