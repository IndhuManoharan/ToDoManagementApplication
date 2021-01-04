package dao;

import org.springframework.data.repository.CrudRepository;

import model.Item;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {

    //TODO
    List<Item> findItemsWithAverageRatingLowerThan(Double rating);
    
}
