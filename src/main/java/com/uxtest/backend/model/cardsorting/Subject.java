package com.uxtest.backend.model.cardsorting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.uxtest.backend.dto.cardsorting.SubjectDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "cardSortingTest_id")
    private CardSortingTest test;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Subject_CategoryWithSubjects",
            joinColumns = { @JoinColumn(name="subject_id")},
            inverseJoinColumns = { @JoinColumn(name = "categoryWithSubject_id")}
    )
    private List<CategoryWithSubjects> categoriesWithSubjects;

    public void addCategory(CategoryWithSubjects category){
        categoriesWithSubjects.add(category);
    }

    public SubjectDTO mapToDTO() {
        return SubjectDTO.builder()
                .id(this.getId())
                .name(this.getName())
                .build();
    }
}
