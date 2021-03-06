import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { HttpClientModule } from "@angular/common/http";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { EmployeeComponent } from "./employee/employee.component";
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';

// What is the purpose of the app.module.ts?
//     It is to startup your application, and set the links to your other modules.

@NgModule({
  declarations: [AppComponent, EmployeeComponent, AddEmployeeComponent, HeaderComponent, FooterComponent],
  imports: [BrowserModule
    , AppRoutingModule
    , HttpClientModule
    , FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
