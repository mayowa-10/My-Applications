package com.MayowaBlog.MayowaBlog.blogPostService;

import com.MayowaBlog.MayowaBlog.blogPostRepository.BlogPostRepository;
import com.MayowaBlog.MayowaBlog.model.BlogPost;

import java.util.List;
import java.util.Optional;

public interface BlogPostService  {
    List<BlogPost> getAllBlogPosts();
    Optional <BlogPost> getPostById(Long id);
    BlogPost createBlogPost(BlogPost blogPost);
    void deleteBlogPost(Long id);
    BlogPost updateBlogPost(BlogPost blogPost, Long id );
}
