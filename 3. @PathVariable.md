
## @PathVariable in SpringMVC



### \spring-servlet.xml
```

<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xmlns:mvc="http://www.springframework.org/schema/mvc"
	xsi:schemaLocation="
		http://www.springframework.org/schema/beans
		http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context 
		http://www.springframework.org/schema/context/spring-context.xsd
		http://www.springframework.org/schema/mvc 
		http://www.springframework.org/schema/mvc/spring-mvc.xsd ">
		
	<!-- <bean id ="handlerMapping" class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"/> -->
		
	<!-- <bean id ="/welcome.htm" class="com.controller.HomeController"/> -->
	<context:component-scan base-package="com.*"/>
	<mvc:annotation-driven/>
	
	<bean id="viewResolver"
		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix">
			<value>/WEB-INF/views/</value>
		</property>
		<property name="suffix">
			<value>.jsp</value>
		</property>
	</bean>
</beans>

```


### \spring-servlet.xml
```
package com.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("great") //class lavel 
public class HomeController {

	//@RequestMapping("/welcome/userName/countryName")
/*	@RequestMapping("/welcome/userName/{countryName}")
	public ModelAndView welcomePage() {
		ModelAndView modelAndView = new ModelAndView("welcome");
		modelAndView.addObject("welcomeMsg", "welcome to my first SpringMVC Application Based on Annotation");
		return modelAndView;
	}*/
	
	/*@RequestMapping("/welcome/{userName}/{countryName}")
	public ModelAndView welcomePage(@PathVariable("userName") String name,@PathVariable("countryName") String countryName) {
		ModelAndView modelAndView = new ModelAndView("welcome");
		modelAndView.addObject("welcomeMsg", "welcome "+name+" You are from "+countryName);
		return modelAndView;
	}*/
	
	// for to many Arguments
	// for this map you have to include -servlet.xml
	/*<beans  xmlns:mvc="http://www.springframework.org/schema/mvc"
			xsi:schemaLocation="
			http://www.springframework.org/schema/mvc 
			http://www.springframework.org/schema/mvc/spring-mvc.xsd ">
			
				<mvc:annotation-driven/> 
        
     */
			
	@RequestMapping("/welcome/{userName}/{countryName}")
	public ModelAndView welcomePage(@PathVariable Map<String,String> pathVars) {
		String name = pathVars.get("userName");
		String countryName = pathVars.get("countryName");
		
		ModelAndView modelAndView = new ModelAndView("welcome");
		modelAndView.addObject("welcomeMsg", "welcome "+name+" You are from "+countryName);
		return modelAndView;
	}

} 



```

### Call above controller using following url's 

`http://localhost:8080/FirstMVC/dipak/india` 





