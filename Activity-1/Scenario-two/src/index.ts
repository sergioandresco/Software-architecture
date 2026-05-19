import { DesktopRenderer } from "./renderers/DesktopRenderer";
import { MobileRenderer } from "./renderers/MobileRenderer";
import { WebRenderer } from "./renderers/WebRenderer";

import { MessageNotification } from "./notifications/MessageNotification";
import { AlertNotification } from "./notifications/AlertNotification";
import { WarningNotification } from "./notifications/WarningNotification";
import { ConfirmationNotification } from "./notifications/ConfirmationNotification";

const desktop = new DesktopRenderer();
const mobile = new MobileRenderer();
const web = new WebRenderer();

console.log("=== Bridge Pattern: Notification System ===\n");

const message = new MessageNotification(desktop);
message.show("New message", "You have a new message from Sergio");

message.setRenderer(mobile);
message.show("New message", "You have a new message from Sergio");

message.setRenderer(web);
message.show("New message", "You have a new message from Sergio");

console.log("");

const alert = new AlertNotification(mobile);
alert.show("Security alert", "Unusual login detected");

const warning = new WarningNotification(mobile);
warning.show("Low battery", "Your battery is below 10%");

const confirmation = new ConfirmationNotification(mobile);
confirmation.show("Purchase confirmed", "Your order #1234 has been placed");

console.log("");

console.log("--- Switching platform at runtime ---");
const criticalAlert = new AlertNotification(desktop);
criticalAlert.show("System down", "The server is not responding");

criticalAlert.setRenderer(web);
criticalAlert.show("System down", "The server is not responding");
