import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { HttpClientModule, HTTP_INTERCEPTORS } from "@angular/common/http";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { EmployeeComponent } from "./employee/employee.component";
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { BasicAuthHtppInterceptorService } from './service/http-intercepter.service';

// What is the purpose of the app.module.ts?
//     It is to startup your application, and set the links to your other modules.

@NgModule({
  declarations: [AppComponent, EmployeeComponent, AddEmployeeComponent, HeaderComponent, FooterComponent, LoginComponent, LogoutComponent],
  imports: [BrowserModule
    , AppRoutingModule
    , HttpClientModule
    , FormsModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS, useClass: BasicAuthHtppInterceptorService, multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
