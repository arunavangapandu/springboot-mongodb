package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.service.TodoService;

// Http is a stateless protocol, http request and http response they dont store any state,
// dont know any previous value, dont save the state of a request.
// Request values are available only for that specific request is executed.
// Model values are available only for that specific request is executed.
// Session --- stores the data on the server side,need lots of memory, 
// store data at minimum possible. 

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@RequestMapping(value="/list-todos", method = RequestMethod.GET)
	public String showTodos(ModelMap model){
	String name = (String)model.get("name");
		model.put("todos", todoService.retrieveTodos(name));
		return "list-todos";
		
	}
	
	@RequestMapping(value="/add-todo", method = RequestMethod.GET)
	public String showAddTodos(ModelMap model){
	
		// // return todo.jsp page.
		return "todo";
	}
	
	@RequestMapping(value="/add-todo", method = RequestMethod.POST)
	public String addTodos(ModelMap model,@RequestParam String desc){
		todoService.addTodo((String)model.get("name"), desc, new Date(), false);
		// return list-todos url(list-todos.jsp).
		return "redirect:/list-todos";
	}
	
}