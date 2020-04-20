import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {EmployeeComponent} from './employee/employee.component';
import {AddEmployeeComponent} from './add-employee/add-employee.component';
import {FormsModule} from '@angular/forms';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import {LoginComponent} from './login/login.component';
import {LogoutComponent} from './logout/logout.component';
import {BasicAuthHtppInterceptorService} from './service/http-intercepter.service';
import {QuectionComponent} from './quection/quection.component';
import {AddQComponent} from './add-q/add-q.component';
import {FeedbackComponent} from './feedback/feedback.component';
import { NotesComponent } from './notes/notes.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatFormFieldModule} from '@angular/material';
import { PaperComponent } from './paper/paper.component';

// What is the purpose of the app.module.ts?
//     It is to startup your application, and set the links to your other modules.

@NgModule({
  declarations: [AppComponent,
    EmployeeComponent,
    AddEmployeeComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent, LogoutComponent
    , QuectionComponent, AddQComponent,
    FeedbackComponent,
    NotesComponent,
    PaperComponent],
    imports: [BrowserModule
        , AppRoutingModule
        , HttpClientModule
        , FormsModule
        , BrowserModule, BrowserAnimationsModule, MatFormFieldModule
    ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS, useClass: BasicAuthHtppInterceptorService, multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
