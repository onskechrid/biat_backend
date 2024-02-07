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


        'spring.jpa.hibernate.hbm2ddl-auto' is an unknown property. Did you mean 'spring.jpa.hibernate.naming.implicit-strategy'?vscode-spring-boot(PROP_UNKNOWN_PROPERTY)
