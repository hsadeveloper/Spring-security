package spring.security.controller;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class GreetingsController {
    @GetMapping("/")
    public String publicPage() {
        return "public";
    }

    @GetMapping("/private")
    public String privatePage(Model model, Authentication authentication) {
        return "private " + getName(authentication);
    }

    private static String getName(Authentication authentication) {
        if (authentication.getPrincipal() instanceof OidcUser oidcUser) {

            return oidcUser.toString();
        }
        return authentication.getName();
    }


}
