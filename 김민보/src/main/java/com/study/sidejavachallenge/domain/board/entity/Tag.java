package com.study.sidejavachallenge.domain.board.entity;

import com.study.sidejavachallenge.common.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tags")
@ToString
public class Tag extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long id;

    @Column(name = "title_kor", length = 100, nullable = false)
    private String titleKor;

    @Column(name = "title_eng", length = 100, nullable = false)
    private String titleEng;

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL)
    private List<TagBridge> tagBridges;

    @Builder
    public Tag(Long id, String titleKor, String titleEng) {
        this.id = id;
        this.titleKor = titleKor;
        this.titleEng = titleEng;
    }

    public static Tag mapToEntity(String titleKor, String titleEng) {
        return Tag.builder()
                .titleKor(titleKor)
                .titleEng(titleEng)
                .build();
    }
}
