import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieCreatorComponent } from './movie-creator.component';

describe('MovieCreatorComponent', () => {
  let component: MovieCreatorComponent;
  let fixture: ComponentFixture<MovieCreatorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MovieCreatorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MovieCreatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
