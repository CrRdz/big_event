# 大事件

[English](./README.md) | 中文

- **后端**：在 `master` 分支  
- **后端**：在 `frontend` 分支  
## 📖 项目介绍

本项目是一个新闻/博客类内容管理系统，支持**用户注册与登录、文章分类管理、文章发布与管理、文件上传**等功能。系统基于前后端分离架构，接口采用 RESTful 风格，所有接口均返回统一格式的 JSON 数据，使用 JWT 进行身份认证。  

## 🛠 技术栈

### 后端（`master` 分支）

- **框架**：SpringBoot 3
- **数据库**：MySQL  
- **认证**：JWT（用户登录鉴权）  
- **缓存**：Redis（Token 缓存、接口优化）  
- **工具**：Maven / npm  
- **文件存储**：阿里云 OSS

### 前端（`frontend` 分支）

- **框架**：Vue 3 
- **UI 框架**：Element Plus  
- **状态管理**：Pinia 
- **HTTP 请求**：Axios  
- **部署**：Nginx  

## 🚀 快速开始

### 1. 克隆项目

```bash
git clone https://github.com/CrRdz/big_event.git
cd big_event
```

### 2. 安装依赖

```bash
npm install
# 或者
yarn install
```

### 3. 启动服务

```bash
npm run dev
```

### 4. 接口访问

本地默认地址：

```
http://localhost:8080
```

## 🔐 鉴权说明

- 用户登录成功后，系统会下发 **JWT 令牌**。

- 前端需要在每次请求时，携带 `Authorization` 请求头：

  ```http
  Authorization: token
  ```

- 若未携带或过期，将返回 `401 Unauthorized`。

## 📂 接口概览

接口分为以下几类（详细见 `InterfaceDocumentation.md` 文件）：  

1. **用户相关**
   - 注册 `/user/register`
   - 登录 `/user/login`
   - 获取用户信息 `/user/userInfo`
   - 更新用户信息 `/user/update`
   - 更新头像 `/user/updateAvatar`
   - 更新密码 `/user/updatePwd`

2. **文章分类相关**
   - 新增分类 `/category [POST]`
   - 分类列表 `/category [GET]`
   - 分类详情 `/category/detail`
   - 更新分类 `/category [PUT]`
   - 删除分类 `/category [DELETE]`

3. **文章管理相关**
   - 新增文章 `/article [POST]`
   - 文章列表（分页） `/article [GET]`
   - 文章详情 `/article/detail`
   - 更新文章 `/article [PUT]`
   - 删除文章 `/article [DELETE]`

4. **文件上传**
   - 上传文件 `/upload`

## 📊 响应数据格式

所有接口返回格式统一：

```json
{
  "code": 0,
  "message": "操作成功",
  "data": {}
}
```

- `code`：状态码（0 表示成功，1 表示失败）
- `message`：提示信息
- `data`：返回的数据对象（可能为 null 或具体内容）

## ⚠️ 错误码约定

| 错误码 | 描述                |
| ------ | ------------------- |
| 0      | 成功                |
| 1      | 失败                |
| 401    | 未授权 / Token 过期 |
| 500    | 服务器错误          |

## 🤝 贡献

欢迎提交 Issue 或 Pull Request 来改进项目。



📌 **完整接口细节请参见** [InterfaceDocumentation](./InterfaceDocumentation_CN.md)
