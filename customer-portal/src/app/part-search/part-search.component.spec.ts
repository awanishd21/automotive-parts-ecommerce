import { ComponentFixture, TestBed } from '@angular/core/testing';
import { PartSearchComponent } from './part-search.component';
import { FormsModule } from '@angular/forms';

describe('PartSearchComponent', () => {
  let component: PartSearchComponent;
  let fixture: ComponentFixture<PartSearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PartSearchComponent ],
      imports: [ FormsModule ]
    }).compileComponents();
    fixture = TestBed.createComponent(PartSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should emit search event', () => {
    spyOn(component.search, 'emit');
    component.part = 'Brake Pad';
    component.city = 'Boston';
    component.search();
    expect(component.search.emit).toHaveBeenCalledWith({ part: 'Brake Pad', city: 'Boston' });
  });
});