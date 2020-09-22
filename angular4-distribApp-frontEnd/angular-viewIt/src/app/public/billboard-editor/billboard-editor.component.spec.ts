import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BillboardEditorComponent } from './billboard-editor.component';

describe('BillboardEditorComponent', () => {
  let component: BillboardEditorComponent;
  let fixture: ComponentFixture<BillboardEditorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BillboardEditorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BillboardEditorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
