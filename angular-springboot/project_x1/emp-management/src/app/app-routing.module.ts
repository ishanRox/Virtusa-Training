import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { EmployeeComponent } from "./employee/employee.component";
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthGaurdService } from './service/auth-gaurd.service';

//url added for routing
//allow angular to show multiple contents depending on which route(url) is chosen
const routes: Routes = [
  { path: "", component: EmployeeComponent, canActivate: [AuthGaurdService] }
  , { path: "addemp", component: AddEmployeeComponent, canActivate: [AuthGaurdService] }
  , { path: 'login', component: LoginComponent, canActivate: [AuthGaurdService] }
  , { path: 'logout', component: LogoutComponent, canActivate: [AuthGaurdService] }
];

//format code shift+alt+f

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
