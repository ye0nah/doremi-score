package doremipizza;

import doremipizza.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyHandler{
    @Autowired
    StoreRepository itemRp;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeliveryCompleted_Rating(@Payload DeliveryCompleted deliveryCompleted){

        if(deliveryCompleted.isMe()){
            if(deliveryCompleted.isMe()){
                if(deliveryCompleted.getScore()!=null){
                    Store store = new Store();
                    store.setStoreId(deliveryCompleted.getStoreId());
                    List<Store> storeList = itemRp.findByStoreId(deliveryCompleted.getMenuId());
                    if(!storeList.isEmpty()){
                        store.setScore(storeList.get(0).getScore()+deliveryCompleted.getScore());
                        store.setCnt(storeList.get(0).getCnt()+1);
                    }else{
                        store.setScore(deliveryCompleted.getScore());
                        store.setCnt(1);
                    }
                    itemRp.save(store);

                }

            }
            System.out.println("##### listener Rating : " + deliveryCompleted.toJson());
        }
    }

}
