
# UML Editor (UML Editor Project Documentation)

## Introduction
This project implements a fundamental UML editor featuring an intuitive and user-friendly interface. It helps users create and manage UML objects, including basic objects (such as Class and Use Case) and various connection lines (Association, Generalization, Composition). The editor also supports selection, grouping, and editing functionalities.

---

## Features

### Creating UML Objects
- Users can create Class or Use Case objects by clicking the respective buttons.

### Connecting Objects
- Supports Association, Generalization, and Composition connections through intuitive drag-and-drop actions.

### Selecting and Grouping Objects
- Supports single and group selection of objects, allowing further combination into composite objects.

### Moving and Editing Objects
- Easily move objects via drag-and-drop; connection lines update automatically.
- Effortlessly change object names through the editing menu.

---

## Project Structure
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

## Usage

### Installation & Execution
1. 請確認你的電腦已安裝 Java 環境（Java 17 或以上版本）。


### Basic Operations
- 使用左側工具列選取欲建立的物件或連結線。
- 點擊編輯區域建立物件，或拖曳建立物件間連結。
- 透過右鍵選單進行物件名稱編輯、群組及取消群組操作。

---

## UML UML Class Diagram
以下是專案架構的 UML 類別圖（位於 docs 資料夾內）：
```
```

---

## Contributing
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

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

如果有任何問題或建議，歡迎隨時聯絡我們或在 Issues 中提出，謝謝你的參與與支持！🚀

If you have any questions or suggestions, feel free to reach out or create an issue. Thank you for your participation and support! 🚀
