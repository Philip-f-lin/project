# 個人專案 - 使用者管理系統
採 SpringBoot + Vue 前後端分離的開發模式，這個系統提供了增、刪、改、查功能。  

# 使用技術
• 前端使用 Vue 框架，採 Element UI 套件  

• 使用 axios 與後端 RESTful API 串接  

• 後端採 Controller 、 Service 、 Dao 三層式架構設計，透過 Mybatis / MybatisPlus 訪問MySQL資料庫

# 快速上手
1、運行環境和所需工具

• 編譯器：IntelliJ IDEA 2023.2.1  

• 項目構建工具：Maven 

• 資料庫：MySQL  

• JDK 版本：jdk11   

2、初始化項目  

• 下載 project 並使用 IntelliJ 開啟  

• 在你的 MtSQL 資料庫中，創建一個名稱為 project 的資料庫，並導入 user table 

• 修改 spring boot 中的 application.yml 配置文件，把 username 和 password 改為自己的  

• 安裝最新版本的 Node.js 和 npm  

# 功能介紹

啟動 Vue  

npm run serve  

運行 SpringbootApplication  

接著輸入 'http://localhost:8085/' 進入到使用者管理頁面    

# 1. 查詢
• 可以透過帳號、信箱、地址查詢  
• 若沒有輸入，則全部查詢
<img width="1352" alt="截圖 2023-10-02 下午10 13 15" src="https://github.com/Philip-f-lin/project/assets/133033495/36101373-c7b8-4fe7-afa3-0bcfc62f4994">
<img width="1353" alt="截圖 2023-10-02 下午10 13 06" src="https://github.com/Philip-f-lin/project/assets/133033495/a85431ae-5a26-4d1d-b56a-5aa967145361">

# 2. 刪除  
• 單個刪除  
• 透過多選框進行多個刪除  
<img width="1355" alt="截圖 2023-10-02 下午10 02 51" src="https://github.com/Philip-f-lin/project/assets/133033495/1d96817d-2079-4c9c-aa74-c5673917b5bf">
<img width="1354" alt="截圖 2023-10-02 下午10 03 52" src="https://github.com/Philip-f-lin/project/assets/133033495/b1139c9d-b1be-4992-90f5-8c3ef5dc713e">
<img width="1354" alt="截圖 2023-10-02 下午10 00 17" src="https://github.com/Philip-f-lin/project/assets/133033495/8b1dcf38-57da-4d8b-8ae3-81e9157757ab">
<img width="1352" alt="截圖 2023-10-02 下午10 01 56" src="https://github.com/Philip-f-lin/project/assets/133033495/dac830d1-4c2f-4e05-994f-7da9216893a8">

# 3. 修改
• 點擊編輯後，會顯示可以修改的資訊  
• 修改完成後，在頁面顯示修改成功及展示修改內容  
<img width="1351" alt="截圖 2023-10-02 下午10 07 41" src="https://github.com/Philip-f-lin/project/assets/133033495/74bf93b6-0a57-456f-8830-1f20389d69f8">
<img width="1352" alt="截圖 2023-10-02 下午10 08 13" src="https://github.com/Philip-f-lin/project/assets/133033495/73512587-ff0b-4059-be6d-33f9f34cddb4">
<img width="1352" alt="截圖 2023-10-02 下午10 09 29" src="https://github.com/Philip-f-lin/project/assets/133033495/80702725-1554-48eb-9873-85db0b3526d3">

# 4. 新增
• 點擊新增後，並輸入資訊，即可在頁面展示  
<img width="1355" alt="截圖 2023-10-02 下午9 54 00" src="https://github.com/Philip-f-lin/project/assets/133033495/1c3dd8ad-75d2-4874-b014-19a77aa6ba20">
<img width="1351" alt="截圖 2023-10-02 下午9 54 39" src="https://github.com/Philip-f-lin/project/assets/133033495/beaf89d5-5517-44ff-a6a6-bb22fe5bde65">
<img width="1353" alt="截圖 2023-10-02 下午9 57 10" src="https://github.com/Philip-f-lin/project/assets/133033495/244a4455-be4a-45f3-8132-9e7093955700">








