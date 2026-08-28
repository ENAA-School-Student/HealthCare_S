package org.example.healthcare_s.config;
import lombok.RequiredArgsConstructor;
import org.example.healthcare_s.enums.Role;
import org.example.healthcare_s.service.security.JwtAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableMethodSecurity
public class ConfigSecurity {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://localhost:5173"));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtAuthFilter jwtAuthFilter) throws Exception {
        http

                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(csrf -> csrf.disable())

                        .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/auth/**").permitAll()
                                .requestMatchers("/patients", "/patients/**").hasAnyAuthority(Role.ROLE_PATIENT.name(), Role.ROLE_ADMIN.name(), Role.ROLE_DOCTOR.name())
                                .requestMatchers(org.springframework.http.HttpMethod.GET, "/medecins", "/medecins/**").hasAnyAuthority(Role.ROLE_DOCTOR.name(), Role.ROLE_ADMIN.name(), Role.ROLE_PATIENT.name())
                                .requestMatchers("/medecins", "/medecins/**").hasAnyAuthority(Role.ROLE_DOCTOR.name(), Role.ROLE_ADMIN.name())
                                .requestMatchers(org.springframework.http.HttpMethod.GET, "/dossierMedical", "/dossierMedical/**").hasAnyAuthority(Role.ROLE_DOCTOR.name(), Role.ROLE_ADMIN.name(), Role.ROLE_PATIENT.name())
                                .requestMatchers("/dossierMedical", "/dossierMedical/**").hasAnyAuthority(Role.ROLE_DOCTOR.name(), Role.ROLE_ADMIN.name())
                                .requestMatchers("/rendezvous", "/rendezvous/**").hasAnyAuthority(Role.ROLE_ADMIN.name(), Role.ROLE_PATIENT.name())
                                .anyRequest().authenticated()
                        )

                .sessionManagement(sess -> sess
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(jwtAuthFilter,
                        UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
