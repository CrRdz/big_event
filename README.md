# Big Event  

English |  [中文](./README_CN.md) 

- **Backend**: on `master` branch  
- **Frontend**: on `frontend` branch  

## 📖 Project Overview  

This project is a news/blog content management system that supports **user registration & login, article category management, article publishing & management, and file uploads**.  
The system is built with a front-end/back-end separation architecture, follows RESTful API design, and uses JWT for authentication.  
All APIs return a standardized JSON response format.  

## 🛠 Tech Stack  

### Backend (`master` branch)  

- **Framework**: Spring Boot 3  
- **Database**: MySQL  
- **Authentication**: JWT (user login authentication)  
- **Cache**: Redis (token caching, performance optimization)  
- **Build tools**: Maven / npm  
- **File Storage**: Aliyun OSS  

### Frontend (`frontend` branch)  

- **Framework**: Vue 3  
- **UI Library**: Element Plus  
- **State Management**: Pinia  
- **HTTP Requests**: Axios  
- **Deployment**: Nginx  

---

## 🚀 Getting Started  

### 1. Clone the project  

```bash
git clone https://github.com/CrRdz/big_event.git
cd big_event
```

### 2. Install dependencies  

```bash
npm install
# or
yarn install
```

### 3. Run the service  

```bash
npm run dev
```

### 4. API Access  

Default local address:  

```
http://localhost:8080
```

---

## 🔐 Authentication  

- After successful login, the system issues a **JWT token**.  

- The frontend must include this token in the `Authorization` header for each request:  

  ```http
  Authorization: token
  ```

- If the token is missing or expired, the server will return `401 Unauthorized`.  

---

## 📂 API Overview  

APIs are grouped into the following categories (see full details in `InterfaceDocumentation.md`):  

1. **User APIs**  
   - Register: `/user/register`  
   - Login: `/user/login`  
   - Get User Info: `/user/userInfo`  
   - Update User Info: `/user/update`  
   - Update Avatar: `/user/updateAvatar`  
   - Update Password: `/user/updatePwd`  

2. **Category APIs**  
   - Add Category: `/category [POST]`  
   - Category List: `/category [GET]`  
   - Category Detail: `/category/detail`  
   - Update Category: `/category [PUT]`  
   - Delete Category: `/category [DELETE]`  

3. **Article APIs**  
   - Add Article: `/article [POST]`  
   - Article List (with pagination): `/article [GET]`  
   - Article Detail: `/article/detail`  
   - Update Article: `/article [PUT]`  
   - Delete Article: `/article [DELETE]`  

4. **File Upload**  
   - Upload File: `/upload`  

---

## 📊 Response Format  

All APIs return a standardized JSON response:  

```json
{
  "code": 0,
  "message": "success",
  "data": {}
}
```

- `code`: status code (0 = success, 1 = failure)  
- `message`: response message  
- `data`: returned data (may be null or contain objects)  

---

## ⚠️ Error Codes  

| Code | Description                  |
| ---- | ---------------------------- |
| 0    | Success                      |
| 1    | Failure                      |
| 401  | Unauthorized / Token Expired |
| 500  | Server Error                 |

---

## 🤝 Contributing  

Contributions are welcome! Feel free to submit Issues or Pull Requests to improve the project.  

📌 **For full API details, please refer to** [InterfaceDocumentation](./InterfaceDocumentation.md)  
