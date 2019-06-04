package com.tts.potluckAdventures.BlogPost;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller         ///this are the annotations starts with the the @ symbol  
@RequestMapping
public class BlogPostContoller {
	
	@Autowired
	private BlogPostRepository blogPostRepository;
	private static List<BlogPost> posts = new ArrayList<>();

	@GetMapping("/")
	
	public String index(BlogPost blogPost, Model model) {
		model.addAttribute("posts", posts);
		return "blogpost/index";
	    }
	
	private BlogPost blogPost;
	
	@GetMapping(value = "/blog_posts/new")
    public String newBlog (BlogPost blogPost) {
        return "blogpost/new";
		
    }
	@PostMapping(value = "/blog_posts/new")
	public String create(BlogPost blogPost, Model model) {
		blogPostRepository.save(blogPost);
	    posts.add(blogPost);
		model.addAttribute("title", blogPost.getTitle());
		model.addAttribute("author", blogPost.getAuthor());
	    model.addAttribute("blogEntry", blogPost.getBlogEntry());
	        return "blogpost/result";
	}
	
	@RequestMapping(value = "/destoryBlogPosts/{id}", method = RequestMethod.DELETE)
	
    public String destroyBlogPostById(@PathVariable Long id, BlogPost blogPost) {

    	for(int i= 0; i < posts.size(); i++) {

    		if(id == posts.get(i).getID()) {

    			posts.remove(i);

    		}

    	}

    	

        blogPostRepository.deleteById(id);

        return "blogpost/index";



    }
	
	
	
	
	@PostMapping(value = "/")
	public String addNewBlogPost(BlogPost blogPost, Model model) {
		blogPostRepository.save(new BlogPost(blogPost.getTitle(), blogPost.getAuthor(), blogPost.getBlogEntry()));
		posts.add(blogPost);
		
		model.addAttribute("id", blogPost.getID());
		model.addAttribute("title", blogPost.getTitle());
		model.addAttribute("author", blogPost.getAuthor());
		model.addAttribute("blogEntry", blogPost.getBlogEntry());
		return "blogpost/result";
	        }
	
    @RequestMapping(value = "/blog_posts/{id}", method = RequestMethod.DELETE)
    public String deletePostWithId(@PathVariable Long id, BlogPost blogPost) {

        blogPostRepository.deleteById(id);
        
		//model.addAttribute("posts", blogPostRepository.findAll());//added to get all post after you delete one 
       
        return "blogpost/index";

    }
    @RequestMapping(value="/blogpost/{id}", method= RequestMethod.GET)
    public String showPostById(@PathVariable long id, BlogPost blogZPost) {
    
    	//model.addAttribute("posts", blogPostRepository.findById(id));
    	
    	return "blogpost/show";
    }
	
}


// add getmapping 
//add requestmapping
//putt
//post
//delete

//update blogpost
// -button to update form 
//- update form
// -put method
// - redirect page

// button click xx
//pass the id to the controller xx
//set the url mapping with the @PathVariable xx
//fond the blog post in the database xx
//serve the view xx
//render the show page with the post(s) that was passed 
