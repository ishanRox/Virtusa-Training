import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuectionComponent } from './quection.component';

describe('QuectionComponent', () => {
  let component: QuectionComponent;
  let fixture: ComponentFixture<QuectionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QuectionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
