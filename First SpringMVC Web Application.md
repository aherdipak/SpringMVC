
## Creating SpringMVC Web Application using Eclipse IDE
### Step 1: Create a Web Project

Using Eclipse IDE, create a Web Project.


### Step 2: Update web.xml

### \web.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
		xmlns="http://java.sun.com/xml/ns/javaee" 
		xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
  <display-name>FirstMVC</display-name>
  
  <servlet>
  	<servlet-name>spring</servlet-name>
  	<servlet-class>
  			org.springframework.web.servlet.DispatcherServlet
  	</servlet-class>
  </servlet>
  
   <servlet-mapping>
  		<servlet-name>spring</servlet-name>
  		<url-pattern>/</url-pattern>
  </servlet-mapping>
  
  
</web-app>
```
### Step 3: create spring-servlet.xml 

create spring-servlet.xml on the same location of web.xml

### \spring-servlet.xml
```

<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xsi:schemaLocation="
		http://www.springframework.org/schema/beans
		http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context 
		http://www.springframework.org/schema/context/spring-context.xsd">
		 
	<bean id ="handlerMapping" class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"/>
		
	<bean id ="/welcome.htm" class="com.controller.HomeController"/>
	
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

### Step 4: create controller class

create controller class 

### \HomeController.java
```

package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HomeController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView modelAndView = new ModelAndView("welcome");
		modelAndView.addObject("welcomeMsg", "welcome in my first SpringMVC Application");
		return modelAndView;
	}

}

```



### Step 5: create JSP page

create Jsp page on location `/WEB-INF/views/welcome.jsp` for showing result on browser 

### \welcome.jsp
```

<html>
<head>
<title>Welcome</title>
</head>
<body>
<h4>First Spring MVC Application Demo</h4>
<h2>${welcomeMsg}</h2>

</body>
</html>
```







## Creating SpringMVC Web Application with annotation(@)
### Step 1: Create a Web Project

Using Eclipse IDE, create a Web Project.


### Step 2: Update web.xml

### \web.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
		xmlns="http://java.sun.com/xml/ns/javaee" 
		xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
  <display-name>FirstMVC</display-name>
  
  <servlet>
  	<servlet-name>spring</servlet-name>
  	<servlet-class>
  			org.springframework.web.servlet.DispatcherServlet
  	</servlet-class>
  </servlet>
  
   <servlet-mapping>
  		<servlet-name>spring</servlet-name>
  		<url-pattern>/</url-pattern>
  </servlet-mapping>
  
  
</web-app>
```
### Step 3: create spring-servlet.xml 

create spring-servlet.xml on the same location of web.xml

### \spring-servlet.xml
```

<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xsi:schemaLocation="
		http://www.springframework.org/schema/beans
		http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context 
		http://www.springframework.org/schema/context/spring-context.xsd">
		 
	<!-- <bean id ="handlerMapping" class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"/> -->
		
	<!-- <bean id ="/welcome.htm" class="com.controller.HomeController"/> -->
	<context:component-scan base-package="com.*"/>
	
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

### Step 4: create controller class

create controller class 

### \HomeController.java
```

package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/welcome.htm")
	public ModelAndView welcomePage() {
		ModelAndView modelAndView = new ModelAndView("welcome");
		modelAndView.addObject("welcomeMsg", "welcome to my first SpringMVC Application Based on Annotation");
		return modelAndView;
	}

} 

```



### Step 5: create JSP page

create Jsp page on location `/WEB-INF/views/welcome.jsp` for showing result on browser  

### \welcome.jsp
```

<html>
<head>
<title>Welcome</title>
</head>
<body>
<h4>First Spring MVC Application Demo</h4>
<h2>${welcomeMsg}</h2>

</body>
</html>
```




