package com.blog.blogproject.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tags")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String tagName;

    @OneToMany(mappedBy = "tag")
    private List<TagBridge> tag;

    @Builder
    public Tag(Long id, String tagName, List<TagBridge> tag) {
        this.id = id;
        this.tagName = tagName;
        this.tag = tag;
    }
}
