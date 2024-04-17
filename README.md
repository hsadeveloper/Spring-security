# Spring-Authenticcation
## How to secure Rest endpoints in Spring Boot?

#### Step 1: Create an empty spring boot application.
  - [Link to Spring Initialzr](https://start.spring.io/)
  - Optional depedencies:
    - DevTools
    - Spring Web
    - Lombock
---
    
#### Step 2: Create two controller endpoints. No security is applied at this stage.

- `public page` - : Accessible to anyone without authentication.
- `private page`:  Requires authentication to access.
---
#### Step 3: Add Spring Security dependency For Authentication

- For a Gradle project, go to the `build.gradle` file and add the following dependency to the dependencies section:

  - Spring Security dependency `'org.springframework.boot:spring-boot-starter-security'`

<i>Once accessing the secure endpoint, a login form will be displayed on the screen.</i>

- `UserName` by default is set to `user`.
- `Password`: A new password will be generated and displayed on the console each time the application is re-run. An example of the generated password looks like `01825654-bd80-4606-913a-53237999f245`.


---

#### Step 4: Create a config class called `SecurityConfig`

To fulfill the condition outlined in `Step 2`, create a SecurityConfig configuration class. This class will contain all our custom security-related configurations.

Since all endpoints are secured by default, our first customization involves creating a custom `SecurityFilterChain` to override the default configurations provided by Spring Boot. We ensure that every request is authenticated, except for specific endpoints that we want to be 'public,' such as the root endpoint (public page), the favicon, and CSS resources. Additionally, we enable form login using `.formLogin()`.

```In the configuration file add the following annotation ```

`EnableWebSecurity` is an annotation provided by Spring Security. It's used to enable Spring Security's web security features in your application.


       @Bean
      SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            return http
                    .authorizeHttpRequests( authorizeHttp -> {
                                authorizeHttp.requestMatchers("/").permitAll();
                                authorizeHttp.requestMatchers("/favicon.svg").permitAll();
                                authorizeHttp.requestMatchers("/css/*").permitAll();
                                authorizeHttp.requestMatchers("/error").permitAll();
                                authorizeHttp.anyRequest().authenticated();
                            })
                    .formLogin(withDefaults())
                    .build();
        }

<p>
To avoid the inconvenience of copying the randomly generated password provided by Spring Boot upon each application startup, we introduce our own UserDetailsService. For demonstration purposes, we implement an in-memory user details service </p>

---
#### Step 5: [OpenID Connect - Google](https://developers.google.com/identity/openid-connect/openid-connect)

To enable Single Sign-On (SSO) login functionality, we need to add dependencies and update our security configuration. 

- Add the required dependency: `implementation("org.springframework.boot:spring-boot-starter-oauth2-client")`.
- Replace the line `.formLogin(withDefaults())` in the config file with the appropriate configuration for OAuth2 login ```oauth2Login(withDefaults())```.
- Update the `application.yml` file to include the necessary properties for SSO login.

  ```spring:
    security:
      oauth2:
        client:
          registration:
            google:
              client-id: <Id>
              client-secret:<secretId>
            github:
              client-id: <Id>
              client-secret: <secretId>```
##### How to get the ```client-id & client-secret```
 - [video Tutorail](https://www.youtube.com/watch?v=5TBffxNBTCs)
 - [Google API& Services/`Credentail`](https://console.cloud.google.com/apis/credentials?project=authentic-bongo-420019)

##### [OAuth2 Login With Github](https://www.youtube.com/watch?v=us0VjFiHogo) 


