package doremipizza;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StoreRepository extends PagingAndSortingRepository<Store, Long>{

    List<Store> findByStoreId(Long storeId);
}