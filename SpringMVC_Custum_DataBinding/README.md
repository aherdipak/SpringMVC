### Requirement:

##### I would except SpringMVC to bind all these form element values except studentMobile form element value with the corresponding student Object properties?
	
- We can achieve such requirement with the help of two concept which are provided by springMVC
 ```markdown
  1. WebDataBinder
  2. InitBinder annotation
 ```
```
@InitBinder
public void initBinder(WebDataBinder binder){
	binder.setDisallowedFields(new String[] {"studentMobile"});
}
```

### Requirement:

##### I want allow to user to provide date in customized format: yyy***MM***dd?
	
	--> using PropertyEditor concept of springMVC
	

###  Requirement:

##### If user submit this form to my application before performing DataBinding task for this form SpringMVC should check user is to provide gender Specification before name i.e Mr./Ms. before name If not then then SpringMVC should consider Ms. as default gender value for name value i.e Miss.XYZ?
	
	-->  we have to create custom PropertyEditor Class
