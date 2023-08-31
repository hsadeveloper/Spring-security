# spring-auth
### Step 1: Create empty spring boot application

### Step 2:  create a `/public` and `/private` page. No security is applied

### Step 3: Add SSO, with oauth2-login

We introduce Spring Security. We create a `SecurityConfig` configuration class, where we will store all of our security-related configuration customizations.

The first customization is to create a custom SecurityFilterChain, to override the defaults that
Spring Boot give us. We make sure that every request must be authenticated, except the few things that we deem "public", such as `/` (public page), the favicon, the css resources, etc. We also introduce `.formLogin()` to ensure form login is enabled for us.

We also introduce our own UserDetailsService, because we don't want to have to copy the random
password that Boot generates every time we boot up the app. It's an in-memory implementation, for demo purposes.

#####   oauth2-login with google 

We add the dependencies and the code to make SSO login work. It requires adding some properties, and just enabling "oauth2 login" in our previous security configuration. Everything stays the same.

We want a nicer "authentication name" when logged in with Google, rather than the ID we get back, so we tweak our GreetingController to display the e-mail when doing SSO login.



