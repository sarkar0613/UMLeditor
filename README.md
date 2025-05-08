
# UML Editor 專案說明 (UML Editor Project Documentation)

## 📌 專案簡介 (Introduction)
這個專案實作了一個基礎的 UML 編輯器，提供直覺且易於操作的介面，幫助使用者建立與管理 UML 物件，包含基本物件（如 Class、Use Case）及多種連結線（Association、Generalization、Composition），並提供選取、群組與編輯功能。

This project implements a fundamental UML editor featuring an intuitive and user-friendly interface. It helps users create and manage UML objects, including basic objects (such as Class and Use Case) and various connection lines (Association, Generalization, Composition). The editor also supports selection, grouping, and editing functionalities.

---

## 🚀 功能特色 (Features)

### 🌟 建立 UML 物件 (Creating UML Objects)
- 點選按鈕即可建立 Class 或 Use Case 物件。
- Users can create Class or Use Case objects by clicking the respective buttons.

### 🔗 連結物件 (Connecting Objects)
- 提供 Association、Generalization、Composition 等連結線類型，直觀拖曳即可完成物件連接。
- Supports Association, Generalization, and Composition connections through intuitive drag-and-drop actions.

### 🖱️ 物件選取與群組 (Selecting and Grouping Objects)
- 支援單一物件選取及群組選取，可進一步將多個物件合併為 Composite 物件。
- Supports single and group selection of objects, allowing further combination into composite objects.

### 🖌️ 移動與編輯物件 (Moving and Editing Objects)
- 透過簡單的拖曳動作，即可移動物件位置並自動調整連接線。
- 可透過編輯功能輕鬆更改物件名稱。
- Easily move objects via drag-and-drop; connection lines update automatically.
- Effortlessly change object names through the editing menu.

---

## 📂 專案架構 (Project Structure)
```
UMLeditor/
├── src/                          # 程式原始碼 (Source Code)
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
│
├── docs/                         # 專案說明文件 (Documentation)
│   ├── UML_Spec.pdf
│   └── UML_diagram.png
│
├── README.md                     # 本文件 (This document)
└── LICENSE                       # 授權文件 (License file)
```

---

## 🛠️ 使用方式 (Usage)

### 安裝與執行 (Installation & Execution)
1. 請確認你的電腦已安裝 Java 環境（Java 17 或以上版本）。
2. 使用以下指令編譯並執行：
```bash
javac src/*.java -d bin
java -cp bin Main
```

### 基本操作 (Basic Operations)
- 使用左側工具列選取欲建立的物件或連結線。
- 點擊編輯區域建立物件，或拖曳建立物件間連結。
- 透過右鍵選單進行物件名稱編輯、群組及取消群組操作。

---

## 🎨 UML 類別架構圖 (UML Class Diagram)
以下是專案架構的 UML 類別圖（位於 docs 資料夾內）：
```
[請於此處插入你的 UML 類別圖]
```

---

## 🤝 貢獻方式 (Contributing)
非常歡迎你一起參與專案的維護與擴充，請遵照以下步驟：

1. Fork 專案到你自己的 GitHub 帳戶。
2. 建立分支進行你的修改：
```bash
git checkout -b feature/new-feature
```
3. 完成修改後提交你的變更：
```bash
git commit -am 'Add new feature'
```
4. 將你的分支推送到 GitHub：
```bash
git push origin feature/new-feature
```
5. 在 GitHub 上提交 Pull Request。

---

## 📝 授權資訊 (License)
本專案採用 MIT 授權條款，詳細內容請參考 [LICENSE](LICENSE)。

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

如果有任何問題或建議，歡迎隨時聯絡我們或在 Issues 中提出，謝謝你的參與與支持！🚀

If you have any questions or suggestions, feel free to reach out or create an issue. Thank you for your participation and support! 🚀
