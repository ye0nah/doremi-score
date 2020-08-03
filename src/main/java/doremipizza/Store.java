package doremipizza;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Store_table")
public class Store {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long storeId;
    private Integer score;
    private Integer cnt;

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
    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }




}
