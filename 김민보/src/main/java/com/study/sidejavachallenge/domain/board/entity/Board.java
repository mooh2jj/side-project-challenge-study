package com.study.sidejavachallenge.domain.board.entity;

import com.study.sidejavachallenge.common.BaseTimeEntity;
import lombok.*;
import javax.persistence.*;
import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "boards")
@ToString
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    private String title;

    private String content;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<TagBridge> tagBridges;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<CategoryBridge> categoryBridges;

    @Builder
    public Board(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

//    public String getMajorCategoryTitle() {
//        return this.categoryBridges.stream()
//                .filter(CategoryBridge::isMajorCategory)
//                .map(CategoryBridge::getCategory)
//                .map(Category::getTitle)
//                .collect(Collectors.toList()
////                .findFirst()
//                .orElse("");
//
//    }
//
//    public String getSubCategoryTitle() {
//        return this.categoryBridges.stream()
//                .filter(categoryBridge -> categoryBridge.getCategory().getCategoryType().equals(CategoryType.SUB))
//                .map(CategoryBridge::getCategory)
//                .map(Category::getTitle)
//                .findFirst()
//                .orElse("");
//    }
//
//    public String getMinorCategoryTitle() {
//        return this.categoryBridges.stream()
//                .filter(categoryBridge -> categoryBridge.getCategory().getCategoryType().equals(CategoryType.MINOR))
//                .map(CategoryBridge::getCategory)
//                .map(Category::getTitle)
//                .findFirst()
//                .orElse("");
//    }
//
//    public String getMinimumCategoryTitle() {
//        return this.categoryBridges.stream()
//                .filter(categoryBridge -> categoryBridge.getCategory().getCategoryType().equals(CategoryType.MINIMUM))
//                .map(CategoryBridge::getCategory)
//                .map(Category::getTitle)
//                .findFirst()
//                .orElse("");
//    }
}
