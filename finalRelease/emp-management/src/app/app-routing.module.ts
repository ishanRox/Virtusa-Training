import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {EmployeeComponent} from './employee/employee.component';
import {AddEmployeeComponent} from './add-employee/add-employee.component';
import {LoginComponent} from './login/login.component';
import {LogoutComponent} from './logout/logout.component';
import {AuthGaurdService} from './service/auth-gaurd.service';
import {QuectionComponent} from './quection/quection.component';
import {AddQComponent} from './add-q/add-q.component';
import {FeedbackComponent} from './feedback/feedback.component';
import {NotesComponent} from './notes/notes.component';
import {PaperComponent} from './paper/paper.component';

// url added for routing
// allow angular to show multiple contents depending on which route(url) is chosen
const routes: Routes = [
  {path: 'notes', component: NotesComponent}
  , {path: 'emp', component: EmployeeComponent, canActivate: [AuthGaurdService]}
  , {path: 'addemp', component: AddEmployeeComponent, canActivate: [AuthGaurdService]}
  , {path: 'login', component: LoginComponent}
  , {path: 'logout', component: LogoutComponent, canActivate: [AuthGaurdService]}
  , {path: 'quections', component: QuectionComponent}
  , {path: 'addq', component: AddQComponent}
  , {
    path: 'feedback', component: FeedbackComponent
  }
  , {
    path: 'paper', component: PaperComponent
  }
];


// format code shift+alt+f

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
