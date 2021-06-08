package com.gestion.stock;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.gestion.stock.dao.impl.FlickrDaoImpl;



public class test {

	public class Question {  
		private int id;  
		private String name;  
		private List<String> answers;  
		  
		//setters and getters  
		  
		public void displayInfo(){  
		    System.out.println(getId()+" "+getName());  
		    System.out.println("answers are:");  
		    Iterator<String> itr=getAnswers().iterator();  
		    while(itr.hasNext()){  
		        System.out.println(itr.next());  
		    }  
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<String> getAnswers() {
			return answers;
		}

		public void setAnswers(List<String> answers) {
			this.answers = answers;
		}  
		  
		}  
	
	
	public static void main(String[] args) {  
	    Resource r=new ClassPathResource("applicationContext.xml");  
	    @SuppressWarnings("deprecation")
		BeanFactory factory=new XmlBeanFactory(r);  
	      
	    Question q=(Question)factory.getBean("LigneCommandeClientDao");  
	    q.displayInfo();  
	      
	}  
	
	

}
