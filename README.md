# 🍔 BurgerMenuApp

A restaurant menu screen built in Java using MVVM architecture. The app connects to Firebase Firestore to fetch and display burger items with adjustable quantities and a live-updating total price.

---

## 📸 Screenshots

| App Design | My App |
|------------|--------|
|| ![Design](screens/design_reference.png) | ![App](screens/my_screenshot.png) | |

---

## 🔧 Tech Stack

- Java
- Firebase Firestore
- MVVM Architecture
- RecyclerView
- LiveData + ViewModel

---

## 📁 Project Structure
BurgerMenuApp/
├── data/ # Remote data (Firestore)
├── domain/ # Repository interface
├── mapper/ # Mappers from Entity to UI model
├── presentation/ # UI and ViewModel
├── utility/ # UI model
└── resources/ # XML, drawables, Firestore sample data

## 🚀 How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/YOUR_USERNAME/BurgerMenuApp.git
2.Open in Android Studio

3.Add your Firebase google-services.json file to app/

4.Create Firestore collection menu_items:
{
  "name": "Cheeseburger",
  "price": 49.99,
  "imageRes": "burger_1"
}
5.Add matching images like burger_1.png in res/drawable/

4.Build and run!
