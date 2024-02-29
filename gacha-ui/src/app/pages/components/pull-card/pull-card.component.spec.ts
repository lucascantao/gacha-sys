import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PullCardComponent } from './pull-card.component';

describe('PullCardComponent', () => {
  let component: PullCardComponent;
  let fixture: ComponentFixture<PullCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PullCardComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PullCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
