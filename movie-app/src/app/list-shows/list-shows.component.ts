import { Component, OnInit } from '@angular/core';
import { Show } from '../model/show.model';
import { MovieService } from '../services/movie.service';

@Component({
  selector: 'app-list-shows',
  templateUrl: './list-shows.component.html',
  styleUrls: ['./list-shows.component.css']
})
export class ListShowsComponent implements OnInit {

  shows : Show[] = [];

  constructor(private service : MovieService) { }

  ngOnInit(): void {
    this.shows = this.service.list_show();
  }

  delete(i : number){
    var ans = confirm("Are you sure to delete?");
    if(ans)
      this.service.remove_show(i);
  }
}
