import { Notification } from "./Notification";

export class WarningNotification extends Notification {
  show(title: string, message: string): void {
    this.renderer.render("warning", title, message);
  }
}
