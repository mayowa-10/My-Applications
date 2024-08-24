package com.MayowaBlog.MayowaBlog.blogPostRepository;

import com.MayowaBlog.MayowaBlog.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

}
