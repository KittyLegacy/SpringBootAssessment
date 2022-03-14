package org.generation.SpringAssessment.repository.entity;


import org.generation.SpringAssessment.controller.dto.ItemDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private Date targetDate;

    public Item() {}

    public Item(ItemDTO itemDTO)
    {
        this.title = itemDTO.getTitle();
        this.description = itemDTO.getDescription();
        this.targetDate = itemDTO.getTargetDate();

    }
    public Integer getId() {return id;}

    public void setId( Integer id) { this.id = id;}

    public String getTitle() { return title;}

    public void setTitle(String title) { this.title = title;}

    public String getDescription() { return description;}

    public void setDescription(String description) { this.description = description;}

    public Date getTargetDate() {return targetDate;}

    public void setTargetDate(Date targetDate) {this.targetDate = targetDate;}


    @Override
    public String toString()
    {
        return "Item{" + id + ", title='" + title +'\'' + ", description='" + description + '\'' + ", targetdate='" + targetDate + '}';

    }

}
