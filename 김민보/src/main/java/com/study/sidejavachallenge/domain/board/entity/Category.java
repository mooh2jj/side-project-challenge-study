package com.study.sidejavachallenge.domain.board.entity;

import com.study.sidejavachallenge.common.BaseTimeEntity;
import com.study.sidejavachallenge.domain.board.dto.response.CategoryResponse;
import lombok.*;
import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "categories")
@ToString
public class Category extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "title", nullable = false)
    private String title;

    private String ord;

    private String logo;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private CategoryStatus status;

    @OneToMany(mappedBy = "parentId")
    private Set<Category> childCategorySet = new LinkedHashSet<>();

    @Builder
    public Category(Long id, Long parentId, String title, String ord, String logo, CategoryStatus status) {
        this.id = id;
        this.parentId = parentId;
        this.title = title;
        this.ord = ord;
        this.logo = logo;
        this.status = status;
    }

    public void delete() {
        this.status = CategoryStatus.REMOVE;
    }
}
