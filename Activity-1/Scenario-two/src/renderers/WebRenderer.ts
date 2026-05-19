import { INotificationRenderer } from "../interfaces/INotificationRenderer";

export class WebRenderer implements INotificationRenderer {
  render(type: string, title: string, message: string): void {
    console.log(`[WEB]     [${type.toUpperCase()}] "${title}" -> ${message}`);
  }
}
