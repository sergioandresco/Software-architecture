export interface INotificationRenderer {
  render(type: string, title: string, message: string): void;
}
