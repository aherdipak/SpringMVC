package com.dac.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value = "/getAdmissionFormPage.htm", method = RequestMethod.GET)
	public ModelAndView getStudentAdmissionFormPage(HttpServletRequest request) throws IOException {
		ModelAndView modelAndView = new ModelAndView("admissionForm");
		modelAndView.addObject("headerMsg", "Enginnering College,India");
		Map<String, String> serverErrorMap = readServerMessageFile(request);
		modelAndView.addObject("ServerError", serverErrorMap.get("dipak.aher3"));
		return modelAndView;
	}

	private Map<String, String> readServerMessageFile(HttpServletRequest request) throws IOException {

		Map<String, String> map = new HashMap<String, String>();
		map.put("ServerError", "I am from server");
		String lang = request.getParameter("siteLanguage");
		if (lang == null || lang.isEmpty()) {
			lang = "en";
		}

		String fileName = "message-" + lang + ".propeties";
		String absolutePath = getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
		File workPath = new File(absolutePath.substring(0, absolutePath.indexOf("WEB-INF")).concat("ServerMessage"));
		if (!workPath.exists()) {
			workPath.mkdirs();
		}
		String flNameWork = workPath + File.separator + fileName;

		File file = new File(flNameWork);

		// System.out.println("File Found : " + file.exists());
		// Read File Content
		// String content = new String(Files.readAllBytes(file.toPath()));
		// System.out.println(content);
		if (file.exists()) {
			FileReader fr = new FileReader(file); // reads the file
			BufferedReader br = new BufferedReader(fr); // creates a buffering character input stream
			String line;
			while ((line = br.readLine()) != null) {
				if(!line.isEmpty() && !line.contains("#") && line.contains("=")) {
					String[] arr = line.split("=");
					if(arr.length>0) {
						map.put(arr[0].trim(), arr[1]);
					}
				}
			}
			fr.close(); // closes the stream and release the resources
			System.out.println(map);
		}
		return map;
	}

}
