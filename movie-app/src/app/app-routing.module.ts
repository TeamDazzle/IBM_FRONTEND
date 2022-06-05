import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddMovieComponent } from './add-movie/add-movie.component';
import { AddShowComponent } from './add-show/add-show.component';
import { ListMoviesComponent } from './list-movies/list-movies.component';
import { ListShowsComponent } from './list-shows/list-shows.component';


const routes: Routes = [
  {path : 'add_movie', component : AddMovieComponent},
  {path : 'add_show', component : AddShowComponent},
  {path : 'list_movies', component : ListMoviesComponent},
  {path : 'list_shows', component : ListShowsComponent},
  {path : '', redirectTo : '/add_movie', pathMatch : 'full'},
  {path : '**', redirectTo : '/list', pathMatch : 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
