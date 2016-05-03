package client;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import java.util.List;

import javax.ws.rs.core.GenericType;

import com.GradeItem;
public class ProfessorGradeBook {

	public ProfessorGradeBook() {
	}
	
	  private Client client;
	   private String REST_SERVICE_URL = "http://localhost:8081/CRUD-GradeBook-snune1-eclipse/rest/Grades/";
	  
	   private static final String SUCCESS_RESULT="<result>success</result>";
	   private static final String PASS = "pass";
	   private static final String FAIL = "fail";
	   

	   public static void main(String[] args){
		   ProfessorGradeBook tester = new ProfessorGradeBook();
	      tester.init();
	      tester.testGetAllGrades();
	      tester.testAddFoodItem();
	     
	   }
	  
	   private void init(){
		      this.client = ClientBuilder.newClient();
		   }
	   private void testGetAllGrades(){
	      GenericType<List<GradeItem>> list = new GenericType<List<GradeItem>>() {};
	      List<GradeItem> GradeItem = client
	         .target(REST_SERVICE_URL)
	         .path("/allGrades")
	         .request(MediaType.APPLICATION_XML)
	         .get(list);
	      String result = PASS;
	      if(GradeItem.isEmpty()){
	         result = FAIL;
	      }
	      System.out.println("Test case name: testGetAllFoodItem, Result: " + result );
	      System.out.println(GradeItem.toString());
	   }
	  
//	   private void testgetStudentGrades(){
//		      GenericType<List<GradeItem>> list = new GenericType<List<GradeItem>>() {};
//		      List<GradeItem> GradeItem = client.target(REST_SERVICE_URL)
//		    			.path("/Read")
//	         .resolveTemplate("id", "1,2")
//	         .request(MediaType.APPLICATION_XML)
//	         .get(list);
//	      String result = FAIL;
//	     
//	      if(FoodItem != null){
//	         result = PASS;
//	      }
//	      System.out.println("Test case name: testGetFoodItem, Result: " + result );
//	      System.out.println(FoodItem.toString());
//	   }
	   private void testAddFoodItem(){
		      Form form = new Form();
		      form.param("gtype","gtype");
		      form.param("sid", "sid");
		      form.param("marks", "marks");
		     
		      GradeItem GradeItem =client
		         .target(REST_SERVICE_URL)
		         .request(MediaType.APPLICATION_XML)
		         .post(Entity.entity(form,
		            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
		            GradeItem.class);
		      System.out.println(GradeItem.toString());
		      String result = PASS;
		      System.out.println("Test case name: testAddFoodItem, Result: " + result );
		   }

}


