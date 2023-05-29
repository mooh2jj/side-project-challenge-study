package com.blog.blogproject.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tag_bridges")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TagBridge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tag_bridge_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @Builder
    public TagBridge(Long id, Tag tag, Board board) {
        this.id = id;
        this.tag = tag;
        this.board = board;
    }
}
