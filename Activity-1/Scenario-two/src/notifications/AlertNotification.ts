import { Notification } from "./Notification";

export class AlertNotification extends Notification {
  show(title: string, message: string): void {
    this.renderer.render("alert", title, message);
  }
}
