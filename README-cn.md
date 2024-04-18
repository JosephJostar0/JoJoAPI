en [English](./README.md) | zh_CN [简体中文](./README-cn.md)

# JoJoAPI: 一个API开放平台
## 系统概述

API开放平台是专为开发者设计的API平台，为用户提供API接口进行调用。系统用户包括普通用户和系统管理员。用户可以注册和登录，浏览和查看API概述和文档，开放接口调用权限，并进行API调用。系统将记录每个用户的API调用行为以供用户计费，并可提供给API提供者进行分析和优化。管理员可以发布接口，下线接口，并集成接口。此外，为了方便用户理解和调用API，系统还应为用户提供模拟调用服务，并提供调用接口的SDK（软件开发工具包）。同时，API应受网关的统一流量控制、统计计费和安全保护。

基于上述功能，系统拟分为五个子系统：

1. **用户前台系统**：用户前台系统将处理用户注册、登录、浏览和查看API概述和文档，以及管理接口调用权限等任务。

2. **后台管理系统**：后台管理系统将负责发布接口、下线接口和集成接口等管理任务。

3. **第三方调用SDK系统**：第三方调用SDK系统将提供SDK，供第三方开发者轻松集成和调用平台提供的API。

4. **模拟接口系统**：模拟接口系统将提供模拟调用服务，允许用户在不影响实际系统的情况下测试API调用。

5. **API网关系统**：API网关系统将管理通过平台进行的所有API调用的统一流量控制、统计计费和安全保护。

![系统概述](./images/system%20overview%20-cn.jpg)

## 系统技术选型

前端: 
- [Nodejs](https://nodejs.org/en)
- [React](https://react.dev/)
- [umi4](https://umijs.org/docs/introduce/introduce)
- [Ant Design Pro](https://pro.ant.design/)

后端:
- [Java21](https://openjdk.org/)
- [MySQL](https://www.mysql.com/)
- [Spring Boot](https://spring.io/projects/spring-boot/)
- [Spring Cloud Gateway](https://spring.io/projects/spring-cloud-gateway)
- [Swagger](https://swagger.io/)
