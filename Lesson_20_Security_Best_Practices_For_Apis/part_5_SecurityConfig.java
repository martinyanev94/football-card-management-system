@Override
protected void configure(HttpSecurity http) throws Exception {
    http
            .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) // Enables CSRF protection
            .and()
            .authorizeRequests()
            .anyRequest().authenticated();
}
