package com.blog.blogproject.domain;

import com.blog.blogproject.dto.BoardRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "boards")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "board_id")
    private Long id;

    private String title;
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "board")
    private List<Comment> comments;

    @OneToMany(mappedBy = "board")
    private List<TagBridge> tags;

    @Builder
    public Board(Long id, String title, String contents, User user, List<Comment> comments, List<TagBridge> tags) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.user = user;
        this.comments = comments;
        this.tags = tags;
    }


    public static Board requestToEntity(BoardRequest request, User user, List<TagBridge> tags) {
        return Board.builder()
                .title(request.getTitle())
                .contents(request.getContents())
                .user(user)
                .tags(tags)
                .build();
    }
}
