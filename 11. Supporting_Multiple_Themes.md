## Form Validations 01 (using JSR 303/349 provided annotations)

### Question 1: 
#### Whatever value provided in a student hobby field that values minimum length of 2 chars and never exceeds 30 chars and if the user violates this rule at a time of submitting the form then my spring application return the same form back to the client with a complete description of the violated rule, How to achieve such things?

##### \Student.java
```
public class Student {

	private String studentName;
	
	@Size(min=2,max=30) // with this annotation on top of this field 
	// WE simply conveying message 
	// hey spring mvc framework whenever you performing data bainding task
	// for studenthobby field and the value which is being with it 
	// value having less than 2 and more than 30 then you simply treet that as data binding error and put that into Databiding eror ref
	// To activate this annotation you have put @Valid annotation in controller before @ModelAttribute
	private String studenthobby;
	
	private Long mobileNumber;
	private Date dob;
	private List<String> skills;
	
	private Address studentAddress;
	
	// getter & setter
}
```
##### \FormValidationController.java
```
@Controller
public class FormValidationController {
	
	
	@RequestMapping(value="/getStudentAdmissionFormPage.htm", method=RequestMethod.GET)
	public ModelAndView getStudentAdmissionFormPage() {
		ModelAndView modelAndView = new ModelAndView("studentAdmissionForm");
		modelAndView.addObject("headerMsg", "Enginnering College,India");
		return modelAndView;
	}
	
	// if we dont put @Valid thenspring mvc completely ignore form validation anotations kept in student class
	@RequestMapping(value="/submitStudentAdmissionForm.htm", method=RequestMethod.POST)
	public ModelAndView submitStudentAdmissionForm(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		
		if(result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("studentAdmissionForm");
			return modelAndView;
		}
		
		ModelAndView modelAndView = new ModelAndView("admissionSuccessNew");
		
		modelAndView.addObject("headerMsg", "Enginnering College,India");
		modelAndView.addObject("msg", "Form Submitted by Name: "+ student.getStudentName() +" Hobby: "+student.getStudenthobby());
		
		return modelAndView;
	}

}

```
##### @Valid 
With this annotation, we simply instructing spring MVC framework hey spring MVC framework whenever you performing data binding task for this student obj. it's only that time you consider all those form validation related annotation which are kept in student class So the idea is very clear if we put @Valid here then and only then spring MVC framework will consider form validation annotations.
