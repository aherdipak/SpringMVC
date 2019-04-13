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



