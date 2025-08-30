import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-part-search',
  template: `
    <form (ngSubmit)="search()">
      <input [(ngModel)]="part" name="part" placeholder="Part Name" required>
      <input [(ngModel)]="city" name="city" placeholder="Your City" required>
      <button type="submit">Search</button>
    </form>
  `
})
export class PartSearchComponent {
  part = '';
  city = '';
  @Output() search = new EventEmitter<{part: string, city: string}>();
  search() {
    this.search.emit({ part: this.part, city: this.city });
  }
}