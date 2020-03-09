import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { EmployeeComponent } from "./employee/employee.component";
import { AddEmployeeComponent } from './add-employee/add-employee.component';

//url added for routing
//allow angular to show multiple contents depending on which route(url) is chosen
const routes: Routes = [{ path: "emp", component: EmployeeComponent }
  , { path: "addemp", component: AddEmployeeComponent }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
