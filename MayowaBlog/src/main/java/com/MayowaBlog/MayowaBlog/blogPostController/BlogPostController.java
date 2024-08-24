package com.MayowaBlog.MayowaBlog.blogPostController;

import com.MayowaBlog.MayowaBlog.blogPostRepository.BlogPostRepository;
import com.MayowaBlog.MayowaBlog.blogPostService.BlogPostServiceImpl;
import com.MayowaBlog.MayowaBlog.model.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("blog/api/post")
public class BlogPostController {
    @Autowired
    private BlogPostServiceImpl blogPostServiceImpl;
    @GetMapping
    public List<BlogPost> getAllBlogPosts(){
        return blogPostServiceImpl.getAllBlogPosts();
    }
    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> getPostById(@PathVariable Long id){
        Optional<BlogPost> post = blogPostServiceImpl.getPostById(id);
        return post.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping()
    public BlogPost createPost (@RequestBody BlogPost blogPost) {
        return blogPostServiceImpl.createBlogPost(blogPost);
    }
    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updatePost (@PathVariable Long id, @RequestBody BlogPost newPost){
        BlogPost updatedPost = blogPostServiceImpl.updateBlogPost(newPost,id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id){
        blogPostServiceImpl.deleteBlogPost(id);
        return ResponseEntity.noContent().build();
    }

}
