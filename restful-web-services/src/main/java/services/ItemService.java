package services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dao.ItemRepository;
import model.Item;
import model.Review;

//@Service
public class ItemService {
	
//	@Autowired
	private final ItemRepository itemRepository;

	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public List<String> getTitlesWithAverageRatingLowerThan(Double rating) {

		List<String> titleList = new ArrayList();
		// TODO
		List<Item> a = itemRepository.findItemsWithAverageRatingLowerThan(rating);
		a.stream().forEach(action -> {
			titleList.add(action.getTitle());
		});

		return titleList;
	}


}
