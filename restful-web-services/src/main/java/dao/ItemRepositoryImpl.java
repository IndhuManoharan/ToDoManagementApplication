package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import model.Item;
import model.Review;

public class ItemRepositoryImpl implements ItemRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public <S extends Item> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Item> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Item> findById(Long id) {
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Item> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Item> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Item entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Item> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Item> findItemsWithAverageRatingLowerThan(Double rating) {

		// TODO
		List<Long> lowerAverageList = getAverageMap(rating);
		List<Item> itemsList = (List<Item>) this.findAllById(lowerAverageList);
		return itemsList;
	}
	
	private List<Long> getAverageMap(Double rating) {
//		Map<Long, Double> ratingMap = new HashMap<>();
		List<Long> lowerAvgList = new ArrayList();
		Iterable<Item> allList = this.findAll();
		Iterator<Item> iterList = allList.iterator();

		while (iterList.hasNext()) {
			Item item = iterList.next();
			Set<Review> v = item.getReviews();
			AtomicInteger avg = new AtomicInteger(0);
			v.forEach(action -> {
				avg.getAndAdd(action.getRating());
			});

			Double avgRating = (double) (avg.get() / v.size());
			if(avgRating < rating) {
				lowerAvgList.add(item.getId());
//				ratingMap.put(item.getId(), avgRating);
			}
		}

		return lowerAvgList;
	}

}
