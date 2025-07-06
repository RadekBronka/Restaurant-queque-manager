# 🍽️ Restaurant Reservation System

Aplikacja do zarządzania rezerwacjami w restauracji

---

## 📌 Opis

Restaurant Reservation System to nowoczesna aplikacja, która umożliwia klientom łatwe składanie rezerwacji stolików poprzez intuicyjną stronę internetową, natomiast obsługa restauracji może zarządzać tymi rezerwacjami za pomocą wygodnego panelu desktopowego w JavaFX.

Wyróżnikiem systemu jest prostota — zamiast rozbudowanej bazy danych, wszystkie dane są zapisywane w plikach JSON, co ułatwia uruchomienie aplikacji bez konieczności konfigurowania serwera bazodanowego.

---

## 🛠️ Technologie

Projekt został zbudowany w oparciu o:

- **Spring Boot** — logika biznesowa, obsługa REST API, odczyt i zapis danych w plikach JSON  
- **JavaFX** — aplikacja desktopowa do obsługi klientów i zarządzania rezerwacjami  
- **HTML + Bootstrap** — responsywny interfejs użytkownika dostępny w przeglądarce  
- **Java** — język programowania dla całego systemu  
- **Pliki JSON** — jako trwały magazyn danych dla rezerwacji  

---

## 🚀 Kluczowe funkcje

✅ Intuicyjna strona internetowa do składania rezerwacji przez klientów  
✅ Formularz rezerwacji w technologii Bootstrap dla lepszej estetyki i UX  
✅ Przechowywanie danych o rezerwacjach w łatwych do edycji plikach JSON  
✅ Panel JavaFX dla obsługi restauracji z funkcjami:  
- przeglądania wszystkich rezerwacji  
- zatwierdzania, odrzucania i edytowania rezerwacji  
- filtrowania i wyszukiwania rezerwacji  
✅ Bezpieczne API w Spring Boot obsługujące dostęp do danych JSON  
✅ Architektura modułowa umożliwiająca łatwą rozbudowę w przyszłości  

---

## 🏗️ Architektura systemu

### 🌐 Frontend Web (HTML + Bootstrap)

- formularz rezerwacji  
- panel potwierdzenia  
- komunikacja przez REST API  

### ⚙️ Backend (Spring Boot)

- walidacja i obsługa rezerwacji  
- zapis i odczyt danych z plików JSON  
- serwowanie statycznych zasobów  

### 🖥️ Desktop App (JavaFX)

- lista rezerwacji  
- akcje związane z ich zatwierdzaniem i aktualizacją  
- komunikacja z tym samym backendem  

---

