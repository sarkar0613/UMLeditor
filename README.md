UML 編輯器 (UML Editor)

專案簡介 (Introduction)

這是一個簡易且實用的 UML 編輯器，提供使用者快速建立與管理 UML 物件、連結線及群組功能。

This is a simple and practical UML editor that enables users to quickly create and manage UML objects, connection lines, and grouping functionalities.

功能特色 (Features)

建立 UML 基本物件 (Create Basic UML Objects)

支援建立 Class 與 Use Case 物件。

Support creating Class and Use Case objects.

UML 連結線 (UML Connection Lines)

提供 Association、Generalization、Composition 三種關聯線。

Offers three connection types: Association, Generalization, and Composition.

選取與群組 (Select and Grouping)

可單選或框選多個物件，並將選取物件合併為複合物件。

Single or multiple objects can be selected and grouped into composite objects.

拖曳與移動物件 (Drag and Move Objects)

提供物件自由拖曳功能，並自動調整相關連結。

Allows free dragging of objects and automatically adjusts connected lines.

編輯物件名稱 (Edit Object Names)

可透過編輯選單輕鬆修改物件名稱。

Easily rename objects via the edit menu.

專案架構 (Project Structure)

UML-Editor/
├── src/
│   ├── CanvasArea.java
│   ├── UMLObject.java
│   ├── BasicObject.java
│   ├── CompositeObject.java
│   ├── ConnectionLine.java
│   ├── AssociationLine.java
│   ├── GeneralizationLine.java
│   ├── CompositionLine.java
│   ├── Button.java
│   ├── SelectionManager.java
│   ├── GroupManager.java
│   └── ObjectMover.java
├── doc/
│   └── UML-diagram.png
└── README.md

如何開始使用 (Getting Started)

環境需求 (Prerequisites)

Java 17 或更高版本

JavaFX 或 Swing

執行專案 (Running the Project)

克隆專案到本機 (Clone this repository to your local machine)：

git clone https://github.com/{YourGitHubAccount}/UML-Editor.git

進入專案資料夾並編譯 (Navigate into the project folder and compile)：

cd UML-Editor
javac -d bin src/*.java

執行應用程式 (Run the application)：

java -cp bin Main

貢獻 (Contributing)

歡迎提出 Issue 與 Pull Request，一起完善專案。

Issues and pull requests are welcome to improve this project.

授權許可 (License)

本專案採用 MIT 授權。

This project is licensed under the MIT License.

