package com.lista.spesa.ListaSpesa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.lista.spesa.ListaSpesa.service.user.CustomUserDetailsService;


@Configuration // È un modo per dire a Spring che questa classe contiene dei bean
@EnableWebSecurity // Abilita il supporto della sicurezza web di Spring Security e consente di
                   // personalizzare la configurazione di sicurezza.
public class SecurityConfig {

    @Bean // Definisce un bean che ritorna un'istanza di CustomUserDetailsService. Questo
          // servizio personalizzato carica i dettagli di autenticazione dell'utente
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean // Definisce un bean che fornisce un'istanza di BCryptPasswordEncoder, che serve
          // per crittografare (hash) le password degli utenti.
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    /*
     * È una classe fornita da Spring Security che utilizza un'implementazione di
     * UserDetailsService
     * per caricare i dettagli di un utente e un PasswordEncoder per verificare la
     * password.
     * DaoAuthenticationProvider è responsabile dell'autenticazione degli utenti
     * rispetto a un database o una fonte dati simile.
     */
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());// ha il compito di caricare i dati relativi agli
                                                                 // utenti dal db
        authProvider.setPasswordEncoder(passwordEncoder());// responsabile della codifica e decodifica della password
        return authProvider;
    }
    // in sintesi Questa configurazione è comunemente usata nelle applicazioni
    // Spring Boot
    // che utilizzano Spring Security per gestire l'autenticazione con un database
    // di utenti.

    @Bean
    // è parte della configurazione della Spring Security per la gestione della
    // sicurezza delle richieste HTTP.
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http // è un'istanza di HttpSecurity per configurare i filtri di sicurezza,
             // autorizzazione e autenticazione per l'applicazione
                .csrf(csrf -> csrf.disable()) // il CSRF è una protezione che impedisce all'utente di eseguire azioni
                                              // non autorizzate. disabilitarlo è comune
                                              // nelle applicazione RESTful o API, dove le richieste non sono basate
                                              // autenticazioni cookie
                .authorizeHttpRequests(auth -> auth // permette di specificare quali richieste devono essere autorizzate
                                                    // o meno
                        .requestMatchers("/api/spese/**").authenticated() // questa regola richiede che qualsiasi
                                                                          // richiesta a l'endpoint si autenticata
                                                                          // solo gli utenti loggati possono aceddere a
                                                                          // questa risorsa
                        .anyRequest().permitAll())// tutte le altre risorse sono permesse senza autenticazione. tipo
                                                  // Homepage
                .formLogin(form -> form
                        .loginPage("/login").permitAll())// Abilita l'autenticazione tramite una pagina. specifica
                                                         // l'indirizzo al quale sarà disponibile
                                                         // e che sarà accessibile da chiunque(senza Autorizzazione)
                .logout(logout -> logout.permitAll()); // stessa cosa per il logout

        return http.build();

        /*
         * SITESI:
         * Il metodo securityFilterChain fa le seguenti cose:
         * 
         * Disabilita CSRF (opzione comune per API REST).
         * Protegge l'endpoint /api/expenses/**, richiedendo che l'utente sia
         * autenticato per accedervi.
         * Permette l'accesso a tutte le altre richieste senza autenticazione.
         * Abilita un form di login all'indirizzo /login, che è accessibile a tutti.
         * Abilita il logout per tutti gli utenti.
         */
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider((authenticationProvider()));
    }
}
