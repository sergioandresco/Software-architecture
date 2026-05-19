import { INotificationRenderer } from "../interfaces/INotificationRenderer";

export abstract class Notification {
  constructor(protected renderer: INotificationRenderer) {}

  setRenderer(renderer: INotificationRenderer): void {
    this.renderer = renderer;
  }

  abstract show(title: string, message: string): void;
}
