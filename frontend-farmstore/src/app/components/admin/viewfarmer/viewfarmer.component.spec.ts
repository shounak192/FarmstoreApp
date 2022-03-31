import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewfarmerComponent } from './viewfarmer.component';

describe('ViewfarmerComponent', () => {
  let component: ViewfarmerComponent;
  let fixture: ComponentFixture<ViewfarmerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewfarmerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewfarmerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
