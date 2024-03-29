package com.study.sidejavachallenge.domain.board.entity;

import com.study.sidejavachallenge.common.BaseTimeEntity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "boards")
@ToString
@Slf4j
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

    public String getMajorCategoryTitle() {

        List<Category> majorCategories = getCategoryBridges().stream()
                .map(CategoryBridge::getCategory)
                .filter(category -> Arrays.stream(category.getOrd().split("\\.")).map(Integer::parseInt).count() == 1)
                .collect(Collectors.toList());

        if (majorCategories.isEmpty()) {
            return null;
        }

        log.info("majorCategories size: {}", majorCategories.size());
        log.info("majorCategories: {}", majorCategories);
        log.info("majorCategories.get(0).getTitle(): {}", majorCategories.get(0).getTitle());

        return majorCategories.get(0).getTitle();
    }

    public String getSubCategoryTitle() {

        List<Category> subCategories = getCategoryBridges().stream()
                .map(CategoryBridge::getCategory)
                .filter(category -> Arrays.stream(category.getOrd().split("\\.")).map(Integer::parseInt).count() == 2)
                .collect(Collectors.toList());

        if (subCategories.isEmpty()) {
            return null;
        }

        log.info("subCategories size: {}", subCategories.size());
        log.info("subCategories: {}", subCategories);
        log.info("subCategories.get(1).getTitle(): {}", subCategories.get(0).getTitle());

        return subCategories.get(0).getTitle();
    }

    public String getMinorCategoryTitle() {

        List<Category> minorCategories = getCategoryBridges().stream()
                .map(CategoryBridge::getCategory)
                .filter(category -> Arrays.stream(category.getOrd().split("\\.")).map(Integer::parseInt).count() == 3)
                .collect(Collectors.toList());

        if (minorCategories.isEmpty()) {
            return null;
        }

        log.info("minorCategories size: {}", minorCategories.size());
        log.info("minorCategories: {}", minorCategories);
        log.info("minorCategories.get(2).getTitle(): {}", minorCategories.get(0).getTitle());

        return minorCategories.get(0).getTitle();
    }

    public String getMinimumCategoryTitle() {

        List<Category> minimumCategories = getCategoryBridges().stream()
                .map(CategoryBridge::getCategory)
                .filter(category -> Arrays.stream(category.getOrd().split("\\.")).map(Integer::parseInt).count() == 4)
                .collect(Collectors.toList());

        if (minimumCategories.isEmpty()) {
            return null;
        }

        log.info("minimumCategories size: {}", minimumCategories.size());
        log.info("minimumCategories: {}", minimumCategories);
        log.info("minimumCategories.get(3).getTitle(): {}", minimumCategories.get(0).getTitle());

        return minimumCategories.get(0).getTitle();
    }
}
