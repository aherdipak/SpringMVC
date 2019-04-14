## Interceptor 01 (Introduction & Implementation)
Many times on the internet you would have observed, you try to access some website sometime you do not get the desired webpage for that request instead you get a simple message on the response webpage. the website is closed for maintenance for some hours or the website is not working at the movement please try to access after some time.

What if you want to do a similar type of message for your application?

### Question 1: 
#### This application should work on all weekdays except for Sunday?

message: " This website does not work on Sunday; please try accessing it on any other weekday !!!"


#### STEPS TO INSTRUCT SPRING MVC TO PERFORM SOME TASK BEFORE HANDINLG A REQUEST:
```markdown
1. INCLUDE A JAVA CLASS which extends "HandlerInterceptorAdaptor" class and override one of ots methods with the name  "preHandle".
2. WRITE THE CODE IN THE "preHandler" method which you want spring mvc to execute before handling the request.
3. put an entry of this newly added java class in the spring configuration file.
```

#####  /DayOfWeekBaseAccessInterceptor.java

```
public class DayOfWeekBaseAccessInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest req,
			HttpServletResponse resp,Object handler) throws Exception {
		// if this method returns true then - application will further handle the request.
		// if this method returns false then -  application will not further handle the request.
		
		Calendar cal =Calendar.getInstance();
		int dayOfWeek = cal.get(cal.DAY_OF_WEEK); // getting the day on which request is made
		if(dayOfWeek == 1) { // 1 means Sunday,2 means Monday .... 7 means Saturday
			resp.getWriter().write("The website is closed on Sunday; Please try accessing it" +
					" on any other week day!!!");
			return false;
		}
		return true;
	}
}

```

The concept is, When any user would request to for a webpage to this application at that movement before handling that request spring mvc framework make a call to this method and this method would returns true its only, then application would further handle or process the request.
If method returns false the application would not handle/proceess that request further and send responce back to the clients browser.

###### Step 2:

Let spring MVC know about this class for that go to the spring configuration file(spring-servlet.xml) and put following code snippet.

```
<!-- here i am simply instructing spring mvc application hey spring in this application i have included class with the name com.controller.DayOfWeekBaseAccessInterceptor so please considor this class while you handle or process any request-->
<mvc:interceptors>
	<bean class="com.controller.DayOfWeekBaseAccessInterceptor"></bean>
</mvc:interceptors>
```

## Interceptor 02 ( more on understanding basics of it...)

`HandlerInterceptorAdapter` provides anather two methods:
```markdown

1. postHandle
2. afterCompletion

```

### Question 1: 
#### When i would make any request to the application and `preHandle()` method returns true and then while processing that request this application should print `"Spring MVC made a call to postHandle method for a webpage request"` message on console and this `"Spring mvc made a call to afterCompletion methid for a webpage request"` message after the view file producess the for that request?

#### /DayOfWeekBaseAccessInterceptor.java
```
@Override
public void postHandle(HttpServletRequest req,HttpServletResponse resp,Object handler,ModelAndView model) throws Exception {
	// this method would be called after spring mvc executes the request handler method for the request.
	System.out.println("HandlerInterceptorAdaptor :  Spring MVC called postHandle method for "+ req.getRequestURI().toString());
}
	
@Override
public void afterCompletion(HttpServletRequest req,HttpServletResponse resp,Object handler,Exception ex)throws Exception {
 // this method would be called after the request object is produced by the view for the request.
System.out.println("HandlerInterceptorAdaptor :  Spring MVC called afterCompletion method for "+ req.getRequestURI().toString());
}
```

### Question 2: 

```
<mvc:interceptors>
	<bean class="com.controller.DayOfWeekBaseAccessInterceptor"></bean>
</mvc:interceptors>
```
 Here,I am simply instructing spring mvc application hey spring in this application i have included class with the name `com.controller.DayOfWeekBaseAccessInterceptor` so please considar this class while you handle or process any/evey request of this application.
 
 Above Interceptor class executes every request of spring mvc application.
 
 ##### What if I want here is this application should consider this interceptor class only for   `"/getStudentAdmissionFormPage.htm"` this url not for other url request.
##### How would we do it?

##### /dispatcher-servlet.xml
```
<mvc:interceptors>
	<mvc:interceptor>
		<mvc:mapping path="/getStudentAdmissionFormPage.htm" />
		<bean class="com.dac.interceptor.DayOfWeekBaseAccessInterceptor"></bean>
	</mvc:interceptor>
</mvc:interceptors>
```

