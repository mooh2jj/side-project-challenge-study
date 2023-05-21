package com.study.sidejavachallenge.domain.board.entity;

import com.study.sidejavachallenge.common.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tag_bridges")
@ToString(exclude = {"board", "tag"})
public class TagBridge extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_bridge_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;

    @Builder
    public TagBridge(Long id, Board board, Tag tag) {
        this.id = id;
        this.board = board;
        this.tag = tag;
    }

    public static TagBridge mapToEntity(Board board, Tag tag) {
        return TagBridge.builder()
                .board(board)
                .tag(tag)
                .build();
    }
}
