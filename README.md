# spring-auth
#### Step 1: Create an empty spring boot application.
  - [Link to Spring Initialzr](https://start.spring.io/)
---
    
#### Step 2: Create a `/public` and `/private` controller page. No security is applied
---
### Step 3: Add Spring Security dependency For Authentication
- Go to the `build.gradle` file and add the following dependency to the depedencies section
-   `'org.springframework.boot:spring-boot-starter-security'`

  ---

#### Step 3: Add SSO, with oauth2-login


We introduce Spring Security. We create a `SecurityConfig` configuration class,where we will store all of our security-related configuration customizations.
The first customization is to create a custom SecurityFilterChain, to override the defaults that
Spring Boot give us. We make sure that every request must be authenticated, except the few things that we deem "public", such as `/` (public page), the favicon, the css resources, etc. We also introduce `.formLogin()` to ensure form login is enabled for us.

We also introduce our own UserDetailsService, because we don't want to have to copy the random
password that Boot generates every time we boot up the app. It's an in-memory implementation, for demo purposes.

#####   oauth2-login with google 

We add the dependencies and the code to make SSO login work. It requires adding some properties, and just enabling "oauth2 login" in our previous security configuration. Everything stays the same.

We want a nicer "authentication name" when logged in with Google, rather than the ID we get back, so we tweak our GreetingController to display the e-mail when doing SSO login.



### Step 4: Create docker file 

How to Dockerize Spring Boot Application?

Create a Spring boot project.
Create and place a Dockerfile inside the root directory of your application.
spring-app/
├── src/
├── Dockerfile
├── ...


Create a jar file using one of the building tool like Gradle or Maven
For Maven run 
                        mvn clean package


For  Gradle run 
                         Gradle build


Make sure to be inside the spring boot project  cd <whatever spring name>  
Build the docker image using the following command
      > docker build -t <image_name>:<tag> <path_to_Dockerfile_director>

   > docker images 
REPOSITORY             TAG                   IMAGE ID        CREATED         SIZE 
spring-security-16    latest                751840e75312    23 hours ago    526MB


   >  docker image rm <ImageId >    
         
Run a Docker container based on a specific Docker image 

 > docker run [OPTIONS] IMAGE [COMMAND] [ARG...]

Ex.        >> docker run -d -p 8081:8080  spring-security-16

The first port : the Docker host ( you can use this port to access to your container) to   access to the container from the outside.
the second one : is the port used by your application.
Example : I want to run tomcat server in a docker container, the default port of tomcat is 8080 and I want to expose my docker on port 9000 so i have to write :
docker run -p 9000:8080 --name myTomcatContainer tomcat






