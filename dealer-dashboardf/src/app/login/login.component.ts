import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-login',
  template: `
    <form (ngSubmit)="login()">
      <label>Dealer ID:
        <input [(ngModel)]="dealerId" name="dealerId" type="number" required>
      </label>
      <button type="submit">Login</button>
    </form>
  `
})
export class LoginComponent {
  dealerId: number | null = null;
  @Output() loggedIn = new EventEmitter<number>();
  login() {
    if (this.dealerId) {
      this.loggedIn.emit(this.dealerId);
    }
  }
}