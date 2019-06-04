package com.tts.potluckAdventures.BlogPost;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class BlogPost {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	 	private Long id; 
	    private String title;
		private String author;
		private String blog_entry;
		
		//non argument constructor
		public BlogPost() {
			
		}
		
		public BlogPost(String title,String author,String blog_entry) {
			this.title = title;
			this.author = author;
			this.blog_entry = blog_entry;
			
		}
		public long getID() {
			return id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getBlogEntry() {
			return blog_entry;
		}

		public void setBlogEntry(String blogEntry) {
			this.blog_entry = blogEntry;
		}
		
		
		@Override
		public String toString() {
			return "BlogPost: id=" + id + ", title=" + title + ", author=" + author + ", blogEntry=" + blog_entry + "";
		}
		
		
		
		
		
		
		
		//1. Create class attributes
		//2. create non-argument constructor
		//3. create argument constructor
		//4.create getters and setters
		
	}


