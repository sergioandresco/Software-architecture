import { INotificationRenderer } from "../interfaces/INotificationRenderer";

export class DesktopRenderer implements INotificationRenderer {
  render(type: string, title: string, message: string): void {
    console.log(`[DESKTOP] [${type.toUpperCase()}] "${title}" -> ${message}`);
  }
}
