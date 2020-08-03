package doremipizza;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Item_table")
public class Item {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long menuId;
    private Long storeId;
    private Integer score;

    @PostPersist
    public void onPostPersist(){
        Rated rated = new Rated();
        BeanUtils.copyProperties(this, rated);
        rated.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }




}
