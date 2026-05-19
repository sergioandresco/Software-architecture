import { Notification } from "./Notification";

export class MessageNotification extends Notification {
  show(title: string, message: string): void {
    this.renderer.render("message", title, message);
  }
}
