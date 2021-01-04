package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
//import org.hibernate.validator.constraints.Length;

@Entity
public class Review {

  @Id
  @GeneratedValue
  private Long id;

//  @Min(0)
//  @Max(10)
  private Integer rating;

//  @Length(max=200)
  private String comment;

  @ManyToOne(optional = false)
  private Item item;

  @ManyToOne(optional = false)
  private User author;

  public Review() {
  }

  public Review(Integer rating, String comment, User author) {
    this.rating = rating;
    this.comment = comment;
    this.author = author;
  }

  public Long getId() {
    return id;
  }

  public Integer getRating() {
    return rating;
  }

  public String getComment() {
    return comment;
  }

  public Item getItem() {
    return item;
  }

  public User getAuthor() {
    return author;
  }

  void setItem(Item item) {
    this.item = item;
  }

  @Override
  public String toString() {
    return "\nReview{" +
        "id=" + id +
        ", rating=" + rating +
        ", comment='" + comment + '\'' +
        '}';
  }
}
