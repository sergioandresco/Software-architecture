import { INotificationRenderer } from "../interfaces/INotificationRenderer";

export class MobileRenderer implements INotificationRenderer {
  render(type: string, title: string, message: string): void {
    console.log(`[MOBILE]  [${type.toUpperCase()}] "${title}" -> ${message}`);
  }
}
