# Scenario 2 — Bridge Pattern: Notification System

**Activity:** Design Patterns  
**Master's degree:** Software Architecture — Universidad de La Sabana  
**Language:** TypeScript

---

## Problem

When managing notifications across multiple platforms (desktop, mobile, web) and multiple types (message, alert, warning, confirmation), traditional inheritance forces you to create one class per combination:

```
NotificacionMensajeWeb
NotificacionAlertaWeb
NotificacionMensajeMovil
NotificacionAlertaMovil
...
```

With 4 types × 3 platforms = **12 classes minimum**, and every new platform or type multiplies the total. This is known as a combinatorial explosion.

---

## Solution — Bridge Pattern (Structural)

The Bridge pattern splits the two independent dimensions into separate hierarchies connected by a reference (the bridge), so they can grow independently.

| Dimension | Role | Classes |
|-----------|------|---------|
| What the notification is | Abstraction | `Notification`, `MessageNotification`, `AlertNotification`, `WarningNotification`, `ConfirmationNotification` |
| Where it is displayed | Implementation | `INotificationRenderer`, `DesktopRenderer`, `MobileRenderer`, `WebRenderer` |

Adding a new platform → **1 new class**. Adding a new type → **1 new class**.

---

## Project structure

```
Scenario-two/
├── src/
│   ├── interfaces/
│   │   └── INotificationRenderer.ts   # The bridge (implementation interface)
│   ├── notifications/
│   │   ├── Notification.ts            # Abstract class (abstraction side)
│   │   ├── AlertNotification.ts
│   │   ├── ConfirmationNotification.ts
│   │   ├── MessageNotification.ts
│   │   └── WarningNotification.ts
│   ├── renderers/
│   │   ├── DesktopRenderer.ts
│   │   ├── MobileRenderer.ts
│   │   └── WebRenderer.ts
│   └── index.ts                       # Demo / entry point
├── package.json
├── tsconfig.json
└── README.md
```

---

## Requirements

- Node.js >= 18
- npm >= 9

---

## Installation

```bash
npm install
```

---

## Run

```bash
npx tsx src/index.ts
```

Expected output:

```
=== Bridge Pattern: Notification System ===

[DESKTOP] [MESSAGE] "New message" -> You have a new message from Sergio
[MOBILE]  [MESSAGE] "New message" -> You have a new message from Sergio
[WEB]     [MESSAGE] "New message" -> You have a new message from Sergio

[MOBILE]  [ALERT] "Security alert" -> Unusual login detected
[MOBILE]  [WARNING] "Low battery" -> Your battery is below 10%
[MOBILE]  [CONFIRMATION] "Purchase confirmed" -> Your order #1234 has been placed

--- Switching platform at runtime ---
[DESKTOP] [ALERT] "System down" -> The server is not responding
[WEB]     [ALERT] "System down" -> The server is not responding
```

---

## How the Bridge works in the code

```typescript
// 1. Pick a renderer (platform)
const mobile = new MobileRenderer();

// 2. Create a notification and inject the renderer (the bridge)
const alert = new AlertNotification(mobile);
alert.show("Security alert", "Unusual login detected");

// 3. Swap the platform at runtime without changing the notification
alert.setRenderer(new WebRenderer());
alert.show("Security alert", "Unusual login detected");
```

---

## Class diagram

```
Client
  |
  | uses
  ↓
<<abstract>>                              <<interface>>
Notification  ◇─────────────────────►  INotificationRenderer
# renderer                               + render(type, title, message)
+ show()*                                    ▲        ▲        ▲
+ setRenderer()                              │        │        │
     ▲                                Desktop  Mobile    Web
     │                                Renderer  Renderer  Renderer
MessageNotification
AlertNotification
WarningNotification
ConfirmationNotification
```

---

## Key benefits

- **Separation of concerns** — notification logic is decoupled from rendering logic
- **Scalability** — new platforms or types require only one new class each
- **Runtime flexibility** — the platform can be swapped dynamically via `setRenderer()`
- **No class explosion** — classes grow by addition, not multiplication
