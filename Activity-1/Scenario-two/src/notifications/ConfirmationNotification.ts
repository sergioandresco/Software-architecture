import { Notification } from "./Notification";

export class ConfirmationNotification extends Notification {
  show(title: string, message: string): void {
    this.renderer.render("confirmation", title, message);
  }
}
