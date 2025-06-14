# 🛣️ Altklausur 2021FT – Straßenkarte in Sternform

Dieses Projekt enthält eine vollständige Lösung zur **OOP-Klausur 2021FT** (UniBw München, 28.06.2021).  
Thema der Aufgaben: **Verkehrsnetz auf sternförmigen Inseln mit Straßensperren und Navigation.**

## 📁 Struktur des Projekts

Der Code befindet sich im Ordner `src/`:

- **`Location`** – Repräsentiert eine Stadt als Koordinatentripel (x, y, z) mit `x + y + z = 0`.
- **`Direction`** – Enum für Bewegungsrichtungen im hexagonalen Gitter.
- **`RoadBlock`** – Modelliert eine Straßensperre zwischen zwei benachbarten Städten.
- **`RoadNetwork`** – Zentrales Verkehrsnetz; enthält Logik für Erreichbarkeit, Sperren und Iteration.
- **`RoadNetworkTest`** – Testklasse zur Überprüfung der Funktionalität.
- **`Main`** – Optional zum Ausprobieren und Debuggen.

## ✅ Hinweise zur Bearbeitung

- Die Klasse `RoadNetwork` implementiert die zentrale Logik und enthält Methoden wie:
  - `contains(Location)` – prüft, ob eine Stadt im Stern liegt.
  - `addRoadBlock(...)` – fügt eine Straßensperre hinzu.
  - `canDrive(...)` – prüft, ob man von einer Stadt in eine Richtung fahren kann.
  - `iterator()` – erlaubt das Durchlaufen aller Städte der Insel.

- Die Tests in **`RoadNetworkTest`** helfen dabei, euer Verständnis zu überprüfen und Fehler früh zu erkennen.

## 🧩 Konzepte

- **Immutable Objekte** (`Location`, `RoadBlock`)
- **Comparable / Hashing / equals**
- **Iterator-Pattern**
- **Sternförmige Geometrie mit dreidimensionalem Koordinatensystem**

---

Viel Erfolg beim Durcharbeiten und Verstehen der Lösung!
