package com.example.boardsideproject.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class TagBridges {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagBridgeId;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Boards boards;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tags tags;

    @Builder
    public TagBridges(Boards boards, Tags tags) {
        this.boards = boards;
        this.tags = tags;
    }
}
