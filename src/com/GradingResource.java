package com;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

@Path("/Grades")
public class GradingResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	GradingService gradingService;

	public GradingResource() {
		gradingService = new GradingService();
	}

	@GET
	@Path("/allGrades")
	@Produces({"application/xml", "application/json"})
	public GradeItem  getGrades() {
		GradeItem grade = new GradeItem();
		grade.setGrades(gradingService.getGradesList());
		return grade;

	}

	@POST
	@Path("/Create")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void createGradeItem(@FormParam("gtype") String gtype,
			@FormParam("sid") String sid,
			@FormParam("marks") String marks,
			@Context HttpServletResponse response) throws IOException, ServletException {

		gradingService.createGradeItem(gtype,sid,marks);
		URI locationURI = URI.create("http://localhost:8080/CRUD-GradeBook-snune1-eclipse/rest/Grades/allGrades");

		response.sendRedirect("http://localhost:8080/CRUD-GradeBook-snune1-eclipse/Response.jsp?status="+Response.Status.CREATED.getStatusCode()+"&location="+locationURI.toString());

	}

	@POST
	@Path("/Update")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void Update(@FormParam("gtype") String gtype,
			@FormParam("sid") String sid,
			@FormParam("marks") String marks,
			@Context HttpServletResponse response) throws IOException {
		gradingService.updateStudentGrade(gtype,sid,marks);	
		URI locationURI = URI.create("http://localhost:8080/CRUD-GradeBook-snune1-eclipse/rest/Grades/allGrades");

		response.sendRedirect("http://localhost:8080/CRUD-GradeBook-snune1-eclipse/Response.jsp?status="+Response.Status.OK.getStatusCode()+"&location="+locationURI.toString());
	}
	@POST
	@Path("/del")
	@Produces({"application/xml", "application/json"})
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void deleteAnimal(@FormParam("gtype") String gtype,
			@FormParam("sid") String sid,@Context HttpServletResponse response) throws IOException  {
		gradingService.deleteStudentGrade(gtype,sid);
		URI locationURI = URI.create("http://localhost:8080/CRUD-GradeBook-snune1-eclipse/rest/Grades/allGrades");

		response.sendRedirect("http://localhost:8080/CRUD-GradeBook-snune1-eclipse/Response.jsp?status="+Response.Status.OK.getStatusCode()+"&location="+locationURI.toString());
	}

	@GET
	@Path("/Read")
	@Produces({"application/xml", "application/json"})
	public GradeItem getStudentGrades(@QueryParam("gtype")String gtype,@Context HttpServletResponse response) throws IOException {
		List<Grading> Student = gradingService.getGrade(gtype);
		GradeItem grade = new GradeItem();
		grade.setGrades(Student);
		return grade;

	}


}