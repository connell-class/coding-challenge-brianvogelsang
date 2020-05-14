import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListsComponent } from './components/lists/lists.component';
import { ListViewComponent } from './components/list-view/list-view.component';

const routes: Routes = [
  { path: 'main', component: ListsComponent },
  { path: 'list', component: ListViewComponent },
  { path: '', redirectTo: 'main', pathMatch: 'full' },
  { path: '**', pathMatch: 'full', redirectTo: 'main' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
