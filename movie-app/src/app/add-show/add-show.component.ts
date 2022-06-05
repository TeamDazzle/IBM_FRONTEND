import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Show } from '../model/show.model';
import { MovieService } from '../services/movie.service';

@Component({
  selector: 'app-add-show',
  templateUrl: './add-show.component.html',
  styleUrls: ['./add-show.component.css']
})
export class AddShowComponent implements OnInit {

  show : Show = new Show();

  constructor(private service : MovieService, private router : Router) { }

  ngOnInit(): void {
  }

  add(){
    this.service.save_show(this.show);
    this.router.navigate(['list_shows']);
  }

}
