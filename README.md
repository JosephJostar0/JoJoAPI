en [English](./README.md) | zh_CN [简体中文](./README-cn.md)

# JoJoAPI: An API Open Platform
## System Overview

The API Open Platform is an API platform designed for developers, providing API interfaces for users to call. The system users include ordinary users and system administrators. Users can register and log in to browse and view API overviews and documents, open interface call permissions, and make API calls. The system will record each user's API call behavior for user billing purposes and can also be provided to API providers for analysis and optimization. Administrators can publish interfaces, take interfaces offline, and integrate interfaces. Additionally, to facilitate user understanding and invocation of APIs, the system should also provide users with simulated invocation services and provide SDKs (Software Development Kits) for calling interfaces. At the same time, APIs should be subject to unified traffic control, statistical billing, and security protection by the gateway.

Based on the functionalities described above, the system is intended to be divided into five subsystems:

1. **User Frontend System**: This subsystem will handle user registration, login, browsing and viewing of API overviews and documents, as well as the management of interface call permissions.

2. **Backend Management System**: The backend management system will be responsible for administrative tasks such as publishing interfaces, taking interfaces offline, and integrating interfaces.

3. **Third-party Call SDK System**: This subsystem will provide SDKs for third-party developers to easily integrate and call the APIs provided by the platform.

4. **Simulated Interface System**: This system will offer simulated invocation services, allowing users to test API calls without affecting the actual system.

5. **API Gateway System**: The API gateway system will manage unified traffic control, statistical billing, and security protection for all API calls made through the platform.

![System Overview](./images/system%20overview.jpg)

## System Technology Selection

frontend: 
- [Nodejs](https://nodejs.org/en)
- [React](https://react.dev/)
- [umi4](https://umijs.org/docs/introduce/introduce)
- [Ant Design Pro](https://pro.ant.design/)

backend:
- [Java21](https://openjdk.org/)
- [MySQL](https://www.mysql.com/)
- [Spring Boot](https://spring.io/projects/spring-boot/)
- [Spring Cloud Gateway](https://spring.io/projects/spring-cloud-gateway)
- [Swagger](https://swagger.io/)
