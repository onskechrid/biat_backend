@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedHeaders("File-Name");
				registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("*")
						.allowedHeaders("*");
			}
		};
	}



  XSSFColor customColor = new XSSFColor(new java.awt.Color(20, 50, 78));
        headerStyle.setFillForegroundColor(customColor);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);


spring.jpa.hibernate.ejb.naming_strategy=org.hibernate.cfg.EJB3NamingStrategy
spring.jpa.hibernate.show_sql=true
spring.jpa.hibernate.format_sql=true
spring.jpa.hibernate.use_sql_comments=false
spring.jpa.hibernate.type=all
spring.jpa.hibernate.disableConnectionTracking=true
spring.jpa.hibernate.default_schema=dentalct
